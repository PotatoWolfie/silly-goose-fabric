package potatowolfie.silly_goose.registry;

import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.LazyRegistryEntryReference;
import net.minecraft.util.Identifier;
import potatowolfie.silly_goose.SillyGoose;
import potatowolfie.silly_goose.entity.goose.variant.GooseVariant;

public class SillyGooseDataComponentTypes {
    public static final ComponentType<LazyRegistryEntryReference<GooseVariant>> GOOSE_VARIANT =
            register("goose_variant", ComponentType.<LazyRegistryEntryReference<GooseVariant>>builder()
                    .codec(LazyRegistryEntryReference.createCodec(
                            SillyGooseRegistryKeys.GOOSE_VARIANT,
                            GooseVariant.ENTRY_CODEC))
                    .packetCodec(LazyRegistryEntryReference.createPacketCodec(
                            SillyGooseRegistryKeys.GOOSE_VARIANT,
                            GooseVariant.ENTRY_PACKET_CODEC))
                    .build());

    private static <T> ComponentType<T> register(String id, ComponentType<T> componentType) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(SillyGoose.MOD_ID, id), componentType);
    }

    public static void register() {
        SillyGoose.LOGGER.info("Registering Data Component Types (just one, its the geese variants again) for " + SillyGoose.MOD_ID);
    }
}