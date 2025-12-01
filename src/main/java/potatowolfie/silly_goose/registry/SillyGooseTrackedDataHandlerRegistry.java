package potatowolfie.silly_goose.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricTrackedDataRegistry;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import potatowolfie.silly_goose.SillyGoose;
import potatowolfie.silly_goose.entity.goose.variant.GooseVariant;

public class SillyGooseTrackedDataHandlerRegistry {
    public static final TrackedDataHandler<RegistryEntry<GooseVariant>> GOOSE_VARIANT =
            TrackedDataHandler.create(GooseVariant.ENTRY_PACKET_CODEC);

    public static void register() {
        FabricTrackedDataRegistry.register(
                Identifier.of(SillyGoose.MOD_ID, "goose_variant"),
                GOOSE_VARIANT
        );
    }
}