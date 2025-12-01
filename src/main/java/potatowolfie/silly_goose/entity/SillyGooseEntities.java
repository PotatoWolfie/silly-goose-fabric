package potatowolfie.silly_goose.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import potatowolfie.silly_goose.SillyGoose;
import potatowolfie.silly_goose.entity.egg.BigGooseEggEntity;
import potatowolfie.silly_goose.entity.egg.GooseEggEntity;
import potatowolfie.silly_goose.entity.egg.SmallGooseEggEntity;
import potatowolfie.silly_goose.entity.goose.GooseEntity;

public class SillyGooseEntities {

    public static final EntityType<GooseEntity> GOOSE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(SillyGoose.MOD_ID, "goose"),
            EntityType.Builder.create(GooseEntity::new, SpawnGroup.CREATURE)
                    .maxTrackingRange(48).dimensions(0.625F, 1.375F)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(SillyGoose.MOD_ID, "goose"))));

    public static final EntityType<GooseEggEntity> WHITE_EGG = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(SillyGoose.MOD_ID, "white_egg"),
            EntityType.Builder.<GooseEggEntity>create(GooseEggEntity::new, SpawnGroup.MISC)
                    .dimensions(0.25F, 0.25F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(10)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(SillyGoose.MOD_ID, "white_egg"))));

    public static final EntityType<BigGooseEggEntity> BIG_WHITE_EGG = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(SillyGoose.MOD_ID, "big_white_egg"),
            EntityType.Builder.<BigGooseEggEntity>create(BigGooseEggEntity::new, SpawnGroup.MISC)
                    .dimensions(0.25F, 0.25F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(10)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(SillyGoose.MOD_ID, "big_white_egg"))));

    public static final EntityType<SmallGooseEggEntity> SMALL_WHITE_EGG = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(SillyGoose.MOD_ID, "small_white_egg"),
            EntityType.Builder.<SmallGooseEggEntity>create(SmallGooseEggEntity::new, SpawnGroup.MISC)
                    .dimensions(0.25F, 0.25F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(10)
                    .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(SillyGoose.MOD_ID, "small_white_egg"))));

    public static void registerModEntities() {
        SillyGoose.LOGGER.info("Registering the HONK HONK (goose) Entities for " + SillyGoose.MOD_ID);
    }
}