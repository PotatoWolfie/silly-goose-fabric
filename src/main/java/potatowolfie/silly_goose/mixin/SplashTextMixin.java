package potatowolfie.silly_goose.mixin;

import net.minecraft.client.resource.SplashTextResourceSupplier;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(SplashTextResourceSupplier.class)
public class SplashTextMixin {

    @Shadow
    private List<String> splashTexts;

    @Inject(method = "apply*",
            at = @At("TAIL"))
    private void addGooseSplashes(CallbackInfo ci) {
        splashTexts = new ArrayList<>(splashTexts);

        splashTexts.add(Text.translatable("splash.silly-goose.honk").getString());
        splashTexts.add(Text.translatable("splash.silly-goose.silly_goose").getString());
        splashTexts.add(Text.translatable("splash.silly-goose.define").getString());
        splashTexts.add(Text.translatable("splash.silly-goose.quack").getString());
        splashTexts.add(Text.translatable("splash.silly-goose.duck").getString());
        splashTexts.add(Text.translatable("splash.silly-goose.57").getString());
        splashTexts.add(Text.translatable("splash.silly-goose.goose_overlords").getString());
        splashTexts.add(Text.translatable("splash.silly-goose.untitled_goose_game").getString());
        splashTexts.add(Text.translatable("splash.silly-goose.no_geese_allowed").getString());
        splashTexts.add(Text.translatable("splash.silly-goose.honking").getString());
    }
}