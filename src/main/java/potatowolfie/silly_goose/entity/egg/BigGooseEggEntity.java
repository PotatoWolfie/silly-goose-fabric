package potatowolfie.silly_goose.entity.egg;

import net.minecraft.entity.*;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import potatowolfie.silly_goose.entity.SillyGooseEntities;
import potatowolfie.silly_goose.entity.goose.GooseEntity;
import potatowolfie.silly_goose.entity.goose.variant.GooseVariants;
import potatowolfie.silly_goose.item.SillyGooseItems;

public class BigGooseEggEntity extends ThrownItemEntity {
    private static final EntityDimensions EMPTY_DIMENSIONS = EntityDimensions.fixed(0.0F, 0.0F);

    public BigGooseEggEntity(EntityType<? extends BigGooseEggEntity> entityType, World world) {
        super(entityType, world);
    }

    public BigGooseEggEntity(World world, LivingEntity owner, ItemStack stack) {
        super(SillyGooseEntities.BIG_WHITE_EGG, owner, world, stack);
    }

    public BigGooseEggEntity(World world, double x, double y, double z, ItemStack stack) {
        super(SillyGooseEntities.BIG_WHITE_EGG, x, y, z, world, stack);
    }

    @Override
    public void handleStatus(byte status) {
        if (status == 3) {
            for(int i = 0; i < 8; ++i) {
                this.getEntityWorld().addParticleClient(
                        new ItemStackParticleEffect(ParticleTypes.ITEM, this.getStack()),
                        this.getX(), this.getY(), this.getZ(),
                        ((double)this.random.nextFloat() - 0.5) * 0.08,
                        ((double)this.random.nextFloat() - 0.5) * 0.08,
                        ((double)this.random.nextFloat() - 0.5) * 0.08);
            }
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        entityHitResult.getEntity().serverDamage(this.getDamageSources().thrown(this, this.getOwner()), 0.0F);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getEntityWorld().isClient()) {
            if (this.random.nextInt(8) == 0) {
                int count = this.random.nextInt(32) == 0 ? 4 : 1;

                for(int j = 0; j < count; ++j) {
                    GooseEntity gooseEntity = SillyGooseEntities.GOOSE.create(this.getEntityWorld(), SpawnReason.TRIGGERED);

                    if (gooseEntity != null) {
                        gooseEntity.setBreedingAge(-24000);
                        gooseEntity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), 0.0F);
                        gooseEntity.setSpawnedFromEgg(true);

                        if (!gooseEntity.recalculateDimensions(EMPTY_DIMENSIONS)) {
                            break;
                        }

                        this.getEntityWorld().spawnEntity(gooseEntity);

                        gooseEntity.setVariant(Variants.getOrDefaultOrThrow(
                                ((ServerWorld)this.getEntityWorld()).getRegistryManager(),
                                GooseVariants.COLD
                        ));
                    }
                }
            }

            this.getEntityWorld().sendEntityStatus(this, (byte)3);
            this.discard();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return SillyGooseItems.BIG_WHITE_EGG;
    }
}