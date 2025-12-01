package potatowolfie.silly_goose.entity.goose.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;

public class BabyGooseFollowGoal extends Goal {
    private final AnimalEntity animal;
    @Nullable
    private AnimalEntity parent;
    private final double speed;
    private int delay;

    private int waterExitTimer = 0;
    private static final int WATER_EXIT_BOOST_INTERVAL = 10;
    private static final double WATER_EXIT_BOOST_STRENGTH = 0.3;

    private float targetYaw = 0;
    private Vec3d lastParentPos = null;

    public BabyGooseFollowGoal(AnimalEntity animal, double speed) {
        this.animal = animal;
        this.speed = speed;
    }

    public boolean canStart() {
        if (this.animal.getBreedingAge() >= 0) {
            return false;
        } else {
            List<? extends AnimalEntity> list = this.animal.getEntityWorld().getNonSpectatingEntities(this.animal.getClass(), this.animal.getBoundingBox().expand(8.0, 4.0, 8.0));
            AnimalEntity animalEntity = null;
            double d = Double.MAX_VALUE;
            Iterator var5 = list.iterator();

            while(var5.hasNext()) {
                AnimalEntity animalEntity2 = (AnimalEntity)var5.next();
                if (animalEntity2.getBreedingAge() >= 0) {
                    double e = this.animal.squaredDistanceTo(animalEntity2);
                    if (!(e > d)) {
                        d = e;
                        animalEntity = animalEntity2;
                    }
                }
            }

            if (animalEntity == null) {
                return false;
            } else if (d < 9.0) {
                return false;
            } else {
                this.parent = animalEntity;
                return true;
            }
        }
    }

    public boolean shouldContinue() {
        if (this.animal.getBreedingAge() >= 0) {
            return false;
        } else if (!this.parent.isAlive()) {
            return false;
        } else {
            double d = this.animal.squaredDistanceTo(this.parent);
            return !(d < 9.0) && !(d > 256.0);
        }
    }

    public void start() {
        this.delay = 0;
        this.lastParentPos = this.parent != null ? this.parent.getEntityPos() : null;
        this.targetYaw = this.animal.getYaw();
        this.waterExitTimer = WATER_EXIT_BOOST_INTERVAL;
    }

    public void stop() {
        this.parent = null;
        this.lastParentPos = null;
    }

    public void tick() {
        if (--this.delay <= 0) {
            this.delay = this.getTickCount(3);

            if (this.animal.isTouchingWater() && this.parent != null) {
                handleDirectSwimming();
            } else {
                this.animal.getNavigation().startMovingTo(this.parent, this.speed);
            }
        } else {
            if (this.animal.isTouchingWater() && this.parent != null) {
                updateRotation();
            }
        }
        checkAndApplyWaterExitBoost();
    }

    private void handleDirectSwimming() {
        if (this.parent == null) return;

        Vec3d targetPos = this.parent.getEntityPos();
        Vec3d currentPos = this.animal.getEntityPos();

        double distance = currentPos.distanceTo(targetPos);
        if (distance < 0.5) {
            updateRotation();
            return;
        }

        Vec3d parentVelocity = this.parent.getVelocity();
        Vec3d predictedPos = targetPos.add(parentVelocity.multiply(2.0));

        Vec3d direction = predictedPos.subtract(currentPos).normalize();

        double newTargetYaw = Math.atan2(-direction.x, direction.z) * (180.0 / Math.PI);

        while (newTargetYaw > 180) newTargetYaw -= 360;
        while (newTargetYaw < -180) newTargetYaw += 360;

        this.targetYaw = (float)newTargetYaw;

        float currentYaw = this.animal.getYaw();
        while (currentYaw > 180) currentYaw -= 360;
        while (currentYaw < -180) currentYaw += 360;

        float yawDiff = this.targetYaw - currentYaw;
        while (yawDiff > 180) yawDiff -= 360;
        while (yawDiff < -180) yawDiff += 360;

        float maxRotation = 12.0f;
        float yawAdjustment = Math.max(-maxRotation, Math.min(maxRotation, yawDiff));
        float newYaw = currentYaw + yawAdjustment;

        this.animal.setYaw(newYaw);
        this.animal.setBodyYaw(newYaw);
        this.animal.setHeadYaw(newYaw);

        if (Math.abs(yawDiff) < 60 && distance > 0.8) {
            double speedMultiplier = Math.min(1.5, distance / 4.0);
            double swimSpeed = this.speed * 0.18 * speedMultiplier;

            Vec3d velocity = this.animal.getVelocity();

            this.animal.setVelocity(
                    direction.x * swimSpeed,
                    velocity.y,
                    direction.z * swimSpeed
            );
            this.animal.velocityModified = true;
        } else {
            Vec3d velocity = this.animal.getVelocity();
            this.animal.setVelocity(
                    velocity.x * 0.7,
                    velocity.y,
                    velocity.z * 0.7
            );
            this.animal.velocityModified = true;
        }

        this.animal.getNavigation().stop();

        this.lastParentPos = targetPos;
    }

    private void updateRotation() {
        if (this.parent == null) return;

        Vec3d targetPos = this.parent.getEntityPos();
        Vec3d currentPos = this.animal.getEntityPos();
        Vec3d direction = targetPos.subtract(currentPos).normalize();

        double newTargetYaw = Math.atan2(-direction.x, direction.z) * (180.0 / Math.PI);
        while (newTargetYaw > 180) newTargetYaw -= 360;
        while (newTargetYaw < -180) newTargetYaw += 360;

        this.targetYaw = (float)newTargetYaw;

        float currentYaw = this.animal.getYaw();
        while (currentYaw > 180) currentYaw -= 360;
        while (currentYaw < -180) currentYaw += 360;

        float yawDiff = this.targetYaw - currentYaw;
        while (yawDiff > 180) yawDiff -= 360;
        while (yawDiff < -180) yawDiff += 360;

        float maxRotation = 8.0f;
        float yawAdjustment = Math.max(-maxRotation, Math.min(maxRotation, yawDiff));
        float newYaw = currentYaw + yawAdjustment;

        this.animal.setYaw(newYaw);
        this.animal.setBodyYaw(newYaw);
        this.animal.setHeadYaw(newYaw);
    }

    private void checkAndApplyWaterExitBoost() {
        waterExitTimer--;
        if (waterExitTimer <= 0) {
            waterExitTimer = WATER_EXIT_BOOST_INTERVAL;

            if (animal.isTouchingWater()) {
                BlockPos abovePos = animal.getBlockPos().up();

                if (!animal.getEntityWorld().getFluidState(abovePos).isIn(net.minecraft.registry.tag.FluidTags.WATER)) {
                    boolean hasNearbyLand = false;
                    BlockPos currentPos = animal.getBlockPos();

                    for (int x = -1; x <= 1; x++) {
                        for (int z = -1; z <= 1; z++) {
                            if (x == 0 && z == 0) continue;

                            BlockPos checkPos = currentPos.add(x, 0, z);
                            BlockPos checkPosAbove = currentPos.add(x, 1, z);

                            boolean isLand = !animal.getEntityWorld().getFluidState(checkPos).isIn(net.minecraft.registry.tag.FluidTags.WATER);
                            boolean isLandAbove = !animal.getEntityWorld().getFluidState(checkPosAbove).isIn(net.minecraft.registry.tag.FluidTags.WATER);

                            if (isLand || isLandAbove) {
                                hasNearbyLand = true;
                                break;
                            }
                        }
                        if (hasNearbyLand) break;
                    }

                    if (hasNearbyLand) {
                        Vec3d velocity = animal.getVelocity();
                        animal.setVelocity(velocity.x, WATER_EXIT_BOOST_STRENGTH, velocity.z);
                        animal.velocityModified = true;
                    }
                }
            }
        }
    }
}