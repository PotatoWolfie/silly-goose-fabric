package potatowolfie.silly_goose.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import potatowolfie.silly_goose.registry.SillyGooseRegistryKeys;

import java.util.concurrent.CompletableFuture;

public class SillyGooseRegistryDataGenerator extends FabricDynamicRegistryProvider {
    public SillyGooseRegistryDataGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        entries.addAll(registries.getOrThrow(SillyGooseRegistryKeys.GOOSE_VARIANT));
        entries.addAll(registries.getOrThrow(RegistryKeys.TRIM_MATERIAL));
        entries.addAll(registries.getOrThrow(RegistryKeys.TRIM_PATTERN));
        entries.addAll(registries.getOrThrow(RegistryKeys.BIOME));
        entries.addAll(registries.getOrThrow(RegistryKeys.CONFIGURED_FEATURE));
        entries.addAll(registries.getOrThrow(RegistryKeys.PLACED_FEATURE));
    }

    @Override
    public String getName() {
        return "HONK HONK data that is registry";
    }
}