package potatowolfie.silly_goose.registry;

import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import potatowolfie.silly_goose.SillyGoose;
import potatowolfie.silly_goose.entity.goose.variant.GooseVariant;

public class SillyGooseRegistryKeys {
    public static final RegistryKey<net.minecraft.registry.Registry<GooseVariant>> GOOSE_VARIANT =
            RegistryKey.ofRegistry(Identifier.of(SillyGoose.MOD_ID, "goose_variant"));

    public static void registerModRegistryKeys() {
        SillyGoose.LOGGER.info("Registering Mod Registry Keys for " + SillyGoose.MOD_ID + " (Love you too warm, cold, and temperate geese)");

        DynamicRegistries.registerSynced(
                GOOSE_VARIANT,
                GooseVariant.CODEC,
                GooseVariant.NETWORK_CODEC
        );
    }
}