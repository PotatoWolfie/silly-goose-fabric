package potatowolfie.silly_goose.entity.goose.variant;

import net.minecraft.entity.passive.AnimalTemperature;
import net.minecraft.entity.spawn.BiomeSpawnCondition;
import net.minecraft.entity.spawn.SpawnConditionSelectors;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.ModelAndTexture;
import net.minecraft.world.biome.Biome;
import potatowolfie.silly_goose.SillyGoose;
import potatowolfie.silly_goose.registry.SillyGooseRegistryKeys;

public class GooseVariants {
    public static final RegistryKey<GooseVariant> TEMPERATE;
    public static final RegistryKey<GooseVariant> WARM;
    public static final RegistryKey<GooseVariant> COLD;
    public static final RegistryKey<GooseVariant> DEFAULT;

    public GooseVariants() {
    }

    private static RegistryKey<GooseVariant> of(Identifier id) {
        return RegistryKey.of(SillyGooseRegistryKeys.GOOSE_VARIANT, id);
    }

    public static void bootstrap(Registerable<GooseVariant> registry) {
        register(registry, TEMPERATE, GooseVariant.Model.NORMAL, "temperate_goose", SpawnConditionSelectors.createFallback(0));
        register(registry, WARM, GooseVariant.Model.WARM, "warm_goose", BiomeTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS);
        register(registry, COLD, GooseVariant.Model.COLD, "cold_goose", BiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS);
    }

    private static void register(Registerable<GooseVariant> registry, RegistryKey<GooseVariant> key, GooseVariant.Model model, String textureName, TagKey<Biome> biomes) {
        RegistryEntryList<Biome> registryEntryList = registry.getRegistryLookup(RegistryKeys.BIOME).getOrThrow(biomes);
        register(registry, key, model, textureName, SpawnConditionSelectors.createSingle(new BiomeSpawnCondition(registryEntryList), 1));
    }

    private static void register(Registerable<GooseVariant> registry, RegistryKey<GooseVariant> key, GooseVariant.Model model, String textureName, SpawnConditionSelectors spawnConditions) {
        Identifier identifier = Identifier.of(SillyGoose.MOD_ID, "textures/entity/goose/" + textureName);
        registry.register(key, new GooseVariant(new ModelAndTexture<>(model, identifier), spawnConditions));
    }

    static {
        TEMPERATE = of(Identifier.of(SillyGoose.MOD_ID, "temperate"));
        WARM = of(Identifier.of(SillyGoose.MOD_ID, "warm"));
        COLD = of(Identifier.of(SillyGoose.MOD_ID, "cold"));
        DEFAULT = TEMPERATE;
    }
}