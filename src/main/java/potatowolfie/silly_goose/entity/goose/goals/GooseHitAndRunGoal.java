package potatowolfie.silly_goose.entity.goose.goals;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import potatowolfie.silly_goose.advancement.HitandRunAdvancementHandler;
import potatowolfie.silly_goose.advancement.HonkandRunAdvancementHandler;
import potatowolfie.silly_goose.damage.SillyGooseDamageTypes;
import potatowolfie.silly_goose.entity.goose.GooseEntity;
import potatowolfie.silly_goose.sound.SillyGooseSounds;

import java.util.EnumSet;
import java.util.List;

public class GooseHitAndRunGoal extends Goal {
    private final GooseEntity goose;
    private PlayerEntity targetPlayer;
    private int cooldownTimer;
    private boolean isRunningAway;
    private double runAwayDistance;

    private Vec3d targetPos = null;
    private int navigationTimeout = 0;
    private int stuckCheckTimer = 0;
    private BlockPos lastPos = null;
    private boolean useDirectSwimming = false;
    private BlockPos nearestWaterPos = null;
    private int waterSearchCooldown = 0;

    private int waterExitTimer = 0;
    private static final int WATER_EXIT_BOOST_INTERVAL = 10;
    private static final double WATER_EXIT_BOOST_STRENGTH = 0.3;

    private static final int MIN_COOLDOWN = 6000;
    private static final int MAX_COOLDOWN = 8400;
    private static final double DETECTION_RADIUS = 32.0;
    private static final double ATTACK_RANGE = 12.0;
    private static final double MIN_RUN_DISTANCE = 8.0;
    private static final double MAX_RUN_DISTANCE = 16.0;
    private static final double RUN_SPEED_MULTIPLIER = 1.5;
    private static final double SWIM_SPEED_MULTIPLIER = 1.5;

    private static final int WATER_SEARCH_INTERVAL = 20;
    private static final int MAX_NAVIGATION_TIMEOUT = 100;
    private static final int STUCK_CHECK_INTERVAL = 20;
    private static final double STUCK_THRESHOLD = 1.0;

    public GooseHitAndRunGoal(GooseEntity goose) {
        this.goose = goose;
        this.cooldownTimer = this.getRandomCooldown();
        this.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
    }

    private int getRandomCooldown() {
        return MIN_COOLDOWN + goose.getRandom().nextInt(MAX_COOLDOWN - MIN_COOLDOWN);
    }

    @Override
    public boolean canStart() {
        if (goose.isBaby()) {
            return false;
        }

        if (cooldownTimer > 0) {
            cooldownTimer--;
            return false;
        }

        PlayerEntity nearestPlayer = goose.getEntityWorld().getClosestPlayer(goose, ATTACK_RANGE);
        if (nearestPlayer == null || !nearestPlayer.isAlive() || nearestPlayer.isSpectator() || nearestPlayer.isCreative()) {
            return false;
        }

        if (hasRecentAttackerNearby()) {
            cooldownTimer = getRandomCooldown();
            return false;
        }

        if (!isChosenAttacker(nearestPlayer)) {
            return false;
        }

        this.targetPlayer = nearestPlayer;
        this.runAwayDistance = MIN_RUN_DISTANCE + goose.getRandom().nextDouble() * (MAX_RUN_DISTANCE - MIN_RUN_DISTANCE);
        return true;
    }

    @Override
    public boolean shouldContinue() {
        if (targetPlayer == null || !targetPlayer.isAlive()) {
            return false;
        }

        if (isRunningAway) {
            double distanceToPlayer = goose.squaredDistanceTo(targetPlayer);
            return distanceToPlayer < runAwayDistance * runAwayDistance;
        }

        return true;
    }

    @Override
    public void start() {
        this.isRunningAway = false;
        updateNearestWater();
        goose.setInHitAndRunMode(true);
        this.waterExitTimer = WATER_EXIT_BOOST_INTERVAL;
    }

    @Override
    public void tick() {
        if (targetPlayer == null) {
            return;
        }

        waterSearchCooldown--;
        if (waterSearchCooldown <= 0) {
            updateNearestWater();
            waterSearchCooldown = WATER_SEARCH_INTERVAL;
        }

        stuckCheckTimer--;
        if (stuckCheckTimer <= 0) {
            checkIfStuck();
            stuckCheckTimer = STUCK_CHECK_INTERVAL;
        }

        if (goose.isTouchingWater()) {
            if (!useDirectSwimming) {
                useDirectSwimming = true;
                goose.getNavigation().stop();
            }
        } else {
            if (useDirectSwimming) {
                useDirectSwimming = false;
            }
        }

        if (!isRunningAway) {
            if (useDirectSwimming) {
                Vec3d playerPos = targetPlayer.getEntityPos();
                handleDirectSwimmingToTarget(playerPos);
            } else {
                goose.getNavigation().startMovingTo(targetPlayer, RUN_SPEED_MULTIPLIER);
            }

            goose.getLookControl().lookAt(targetPlayer, 30.0F, 30.0F);

            if (goose.squaredDistanceTo(targetPlayer) <= 4.0) {
                goose.playSound(SillyGooseSounds.GOOSE_ATTACK, 1.0F, 1.0F);
                RegistryKey<DamageType> damageTypeKey;
                int random = goose.getRandom().nextInt(3);
                switch (random) {
                    case 0 -> damageTypeKey = SillyGooseDamageTypes.GOOSE_BOTHER;
                    case 1 -> damageTypeKey = SillyGooseDamageTypes.GOOSE_PECK;
                    default -> damageTypeKey = SillyGooseDamageTypes.GOOSE_HONK;
                }

                DamageSource damageSource = new DamageSource(
                        goose.getEntityWorld().getRegistryManager()
                                .getOrThrow(RegistryKeys.DAMAGE_TYPE)
                                .getEntry(damageTypeKey.getValue()).get(),
                        goose
                );

                float damage = (float) goose.getAttributeValue(EntityAttributes.ATTACK_DAMAGE);
                targetPlayer.damage((ServerWorld) goose.getEntityWorld(), damageSource, damage);

                if (targetPlayer instanceof ServerPlayerEntity serverPlayer) {
                    ItemStack mainhandItem = goose.getEquippedStack(EquipmentSlot.MAINHAND);
                    if (!mainhandItem.isEmpty()) {
                        HitandRunAdvancementHandler.grantHitandRunAdvancement(serverPlayer);
                    } else {
                        HonkandRunAdvancementHandler.grantHonkandRunAdvancement(serverPlayer);
                    }
                }

                isRunningAway = true;
                setupEscapeTarget();
                notifyNearbyGeese();
            }
        } else {
            if (targetPos != null) {
                navigationTimeout--;

                double distanceToTarget = goose.getEntityPos().distanceTo(targetPos);
                if (distanceToTarget < 2.0 || goose.squaredDistanceTo(targetPlayer) >= runAwayDistance * runAwayDistance) {
                    targetPos = null;
                    goose.getNavigation().stop();
                    useDirectSwimming = false;
                    return;
                }

                if (useDirectSwimming) {
                    handleDirectSwimming();
                } else {
                    if (navigationTimeout % 20 == 0 && distanceToTarget > 3.0) {
                        goose.getNavigation().startMovingTo(targetPos.x, targetPos.y, targetPos.z, RUN_SPEED_MULTIPLIER);
                    }
                }

                if (navigationTimeout <= 0) {
                    setupEscapeTarget();
                }
            } else {
                setupEscapeTarget();
            }
        }
        checkAndApplyWaterExitBoost();
    }

    @Override
    public void stop() {
        this.targetPlayer = null;
        this.isRunningAway = false;
        this.cooldownTimer = getRandomCooldown();
        this.targetPos = null;
        this.useDirectSwimming = false;
        goose.getNavigation().stop();
        goose.setInHitAndRunMode(false);
    }

    private void setupEscapeTarget() {
        if (targetPlayer == null) return;

        double dx = goose.getX() - targetPlayer.getX();
        double dz = goose.getZ() - targetPlayer.getZ();
        double distance = Math.sqrt(dx * dx + dz * dz);

        if (distance < 0.1) {
            double angle = goose.getRandom().nextDouble() * Math.PI * 2.0;
            dx = Math.cos(angle);
            dz = Math.sin(angle);
            distance = 1.0;
        }

        double escapeIncrement = goose.isTouchingWater() ? 8.0 : runAwayDistance;
        dx = (dx / distance) * escapeIncrement;
        dz = (dz / distance) * escapeIncrement;

        double targetX = goose.getX() + dx;
        double targetZ = goose.getZ() + dz;
        double targetY = goose.getY();

        BlockPos targetBlockPos = BlockPos.ofFloored(targetX, targetY, targetZ);
        boolean targetIsWater = goose.getEntityWorld().getFluidState(targetBlockPos).isIn(net.minecraft.registry.tag.FluidTags.WATER);

        if (targetIsWater || goose.isTouchingWater()) {
            BlockPos checkPos = goose.isTouchingWater() ? goose.getBlockPos() : targetBlockPos;

            checkPos = BlockPos.ofFloored(targetX, checkPos.getY(), targetZ);
            while (goose.getEntityWorld().getFluidState(checkPos).isIn(net.minecraft.registry.tag.FluidTags.WATER)) {
                targetY = checkPos.getY() + 1.0;
                checkPos = checkPos.up();
            }
        }

        setTarget(new Vec3d(targetX, targetY, targetZ));
    }

    private void checkAndApplyWaterExitBoost() {
        waterExitTimer--;
        if (waterExitTimer <= 0) {
            waterExitTimer = WATER_EXIT_BOOST_INTERVAL;

            if (goose.isTouchingWater()) {
                BlockPos abovePos = goose.getBlockPos().up();

                if (!goose.getEntityWorld().getFluidState(abovePos).isIn(net.minecraft.registry.tag.FluidTags.WATER)) {
                    boolean hasNearbyLand = false;
                    BlockPos currentPos = goose.getBlockPos();

                    for (int x = -1; x <= 1; x++) {
                        for (int z = -1; z <= 1; z++) {
                            if (x == 0 && z == 0) continue;

                            BlockPos checkPos = currentPos.add(x, 0, z);
                            BlockPos checkPosAbove = currentPos.add(x, 1, z);

                            boolean isLand = !goose.getEntityWorld().getFluidState(checkPos).isIn(net.minecraft.registry.tag.FluidTags.WATER);
                            boolean isLandAbove = !goose.getEntityWorld().getFluidState(checkPosAbove).isIn(net.minecraft.registry.tag.FluidTags.WATER);

                            if (isLand || isLandAbove) {
                                hasNearbyLand = true;
                                break;
                            }
                        }
                        if (hasNearbyLand) break;
                    }

                    if (hasNearbyLand) {
                        Vec3d velocity = goose.getVelocity();
                        goose.setVelocity(velocity.x, WATER_EXIT_BOOST_STRENGTH, velocity.z);
                        goose.velocityDirty = true;
                    }
                }
            }
        }
    }

    private void handleDirectSwimming() {
        if (targetPos == null) return;

        Vec3d currentPos = goose.getEntityPos();
        Vec3d direction = targetPos.subtract(currentPos).normalize();

        double targetYaw = Math.atan2(-direction.x, direction.z) * (180.0 / Math.PI);
        float currentYaw = goose.getYaw();

        while (targetYaw > 180) targetYaw -= 360;
        while (targetYaw < -180) targetYaw += 360;
        while (currentYaw > 180) currentYaw -= 360;
        while (currentYaw < -180) currentYaw += 360;

        float yawDiff = (float)(targetYaw - currentYaw);
        while (yawDiff > 180) yawDiff -= 360;
        while (yawDiff < -180) yawDiff += 360;

        float maxRotation = 15.0f;
        float yawAdjustment = Math.max(-maxRotation, Math.min(maxRotation, yawDiff));
        float newYaw = currentYaw + yawAdjustment;

        goose.setYaw(newYaw);
        goose.setBodyYaw(newYaw);
        goose.setHeadYaw(newYaw);

        if (Math.abs(yawDiff) < 45) {
            double swimSpeed = SWIM_SPEED_MULTIPLIER * 0.15;
            Vec3d velocity = goose.getVelocity();

            goose.setVelocity(
                    direction.x * swimSpeed,
                    velocity.y,
                    direction.z * swimSpeed
            );
            goose.velocityDirty = true;
        } else {
            Vec3d velocity = goose.getVelocity();
            goose.setVelocity(
                    velocity.x * 0.5,
                    velocity.y,
                    velocity.z * 0.5
            );
            goose.velocityDirty = true;
        }
    }

    private void handleDirectSwimmingToTarget(Vec3d target) {
        Vec3d currentPos = goose.getEntityPos();
        Vec3d direction = target.subtract(currentPos).normalize();

        double targetYaw = Math.atan2(-direction.x, direction.z) * (180.0 / Math.PI);
        float currentYaw = goose.getYaw();

        while (targetYaw > 180) targetYaw -= 360;
        while (targetYaw < -180) targetYaw += 360;
        while (currentYaw > 180) currentYaw -= 360;
        while (currentYaw < -180) currentYaw += 360;

        float yawDiff = (float)(targetYaw - currentYaw);
        while (yawDiff > 180) yawDiff -= 360;
        while (yawDiff < -180) yawDiff += 360;

        float maxRotation = 15.0f;
        float yawAdjustment = Math.max(-maxRotation, Math.min(maxRotation, yawDiff));
        float newYaw = currentYaw + yawAdjustment;

        goose.setYaw(newYaw);
        goose.setBodyYaw(newYaw);
        goose.setHeadYaw(newYaw);

        if (Math.abs(yawDiff) < 45) {
            double swimSpeed = SWIM_SPEED_MULTIPLIER * 0.15;
            Vec3d velocity = goose.getVelocity();

            goose.setVelocity(
                    direction.x * swimSpeed,
                    velocity.y,
                    direction.z * swimSpeed
            );
            goose.velocityDirty = true;
        } else {
            Vec3d velocity = goose.getVelocity();
            goose.setVelocity(
                    velocity.x * 0.5,
                    velocity.y,
                    velocity.z * 0.5
            );
            goose.velocityDirty = true;
        }
    }

    private void updateNearestWater() {
        BlockPos goosePos = goose.getBlockPos();
        BlockPos nearest = null;
        double nearestDistance = Double.MAX_VALUE;

        for (BlockPos pos : BlockPos.iterate(
                goosePos.add(-32, -16, -32),
                goosePos.add(32, 16, 32))) {
            if (goose.getEntityWorld().getFluidState(pos).isIn(net.minecraft.registry.tag.FluidTags.WATER)) {
                double distance = goosePos.getSquaredDistance(pos);
                if (distance < nearestDistance) {
                    nearestDistance = distance;
                    nearest = pos.toImmutable();
                }
            }
        }

        this.nearestWaterPos = nearest;
    }

    private void setTarget(Vec3d target) {
        this.targetPos = target;
        this.navigationTimeout = MAX_NAVIGATION_TIMEOUT;

        if (goose.isTouchingWater()) {
            useDirectSwimming = true;
            goose.getNavigation().stop();
        } else {
            useDirectSwimming = false;
            this.goose.getNavigation().startMovingTo(target.x, target.y, target.z, RUN_SPEED_MULTIPLIER);
        }
    }

    private void checkIfStuck() {
        BlockPos currentPos = goose.getBlockPos();

        if (lastPos != null && targetPos != null) {
            double distanceMoved = currentPos.getSquaredDistance(lastPos);

            if (distanceMoved < STUCK_THRESHOLD) {
                targetPos = null;
                goose.getNavigation().stop();
            }
        }

        lastPos = currentPos.toImmutable();
    }

    private boolean hasRecentAttackerNearby() {
        Box searchBox = goose.getBoundingBox().expand(DETECTION_RADIUS);
        List<GooseEntity> nearbyGeese = goose.getEntityWorld().getEntitiesByClass(
                GooseEntity.class,
                searchBox,
                g -> g != goose && g.isAlive()
        );

        for (GooseEntity otherGoose : nearbyGeese) {
            if (otherGoose.getNavigation().isFollowingPath() && isGooseAttacking(otherGoose)) {
                return true;
            }
        }

        return false;
    }

    private boolean isGooseAttacking(GooseEntity otherGoose) {
        if (!otherGoose.getNavigation().isFollowingPath()) {
            return false;
        }

        PlayerEntity nearPlayer = otherGoose.getEntityWorld().getClosestPlayer(otherGoose, DETECTION_RADIUS);
        if (nearPlayer != null) {
            double dist = otherGoose.squaredDistanceTo(nearPlayer);
            return dist < MAX_RUN_DISTANCE * MAX_RUN_DISTANCE;
        }

        return false;
    }

    private boolean isChosenAttacker(PlayerEntity player) {
        Box searchBox = goose.getBoundingBox().expand(DETECTION_RADIUS);
        List<GooseEntity> nearbyGeese = goose.getEntityWorld().getEntitiesByClass(
                GooseEntity.class,
                searchBox,
                g -> g.isAlive() && !g.isBaby() && g.squaredDistanceTo(player) <= ATTACK_RANGE * ATTACK_RANGE
        );

        if (nearbyGeese.isEmpty()) {
            return true;
        }

        ItemStack ourMainhand = goose.getEquippedStack(EquipmentSlot.MAINHAND);
        boolean weHaveWeapon = !ourMainhand.isEmpty() && ourMainhand.isIn(ItemTags.SWORDS);

        int geeseWithWeapons = 0;
        int totalEligibleGeese = 0;

        for (GooseEntity otherGoose : nearbyGeese) {
            totalEligibleGeese++;
            ItemStack theirMainhand = otherGoose.getEquippedStack(EquipmentSlot.MAINHAND);
            if (!theirMainhand.isEmpty() && theirMainhand.isIn(ItemTags.SWORDS)) {
                geeseWithWeapons++;
            }
        }

        if (weHaveWeapon) {
            if (geeseWithWeapons > 0) {
                return goose.getRandom().nextInt(geeseWithWeapons + totalEligibleGeese - geeseWithWeapons) < geeseWithWeapons;
            }
            return goose.getRandom().nextFloat() < 0.75f;
        }

        if (geeseWithWeapons > 0) {
            return goose.getRandom().nextFloat() < 0.25f / totalEligibleGeese;
        }

        return goose.getRandom().nextInt(totalEligibleGeese) == 0;
    }

    private void notifyNearbyGeese() {
        Box searchBox = goose.getBoundingBox().expand(DETECTION_RADIUS);
        List<GooseEntity> nearbyGeese = goose.getEntityWorld().getEntitiesByClass(
                GooseEntity.class,
                searchBox,
                g -> g != goose && g.isAlive()
        );

        for (GooseEntity otherGoose : nearbyGeese) {
        }
    }
}