package potatowolfie.silly_goose.advancement;

import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementProgress;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class HonkandRunAdvancementHandler {

    public static void grantHonkandRunAdvancement(ServerPlayerEntity player) {
        MinecraftServer server = player.getEntityWorld().getServer();
        if (server == null) return;

        Identifier advId = Identifier.of("silly-goose", "adventure/honk_and_run");
        AdvancementEntry advancement = server.getAdvancementLoader().get(advId);

        if (advancement != null) {
            AdvancementProgress progress = player.getAdvancementTracker().getProgress(advancement);
            if (!progress.isDone()) {
                player.getAdvancementTracker().grantCriterion(advancement, "honked");
            }
        }
    }
}