package potatowolfie.silly_goose.mixin;

import net.minecraft.client.resource.SplashTextResourceSupplier;
import net.minecraft.text.Style;
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
    private List<Text> splashTexts;

    @Inject(method = "apply*",
            at = @At("TAIL"))
    private void addGooseSplashes(CallbackInfo ci) {
        splashTexts = new ArrayList<>(splashTexts);

        Style splashStyle = Style.EMPTY.withColor(0xFFFF00);

        splashTexts.add(Text.translatable("splash.silly-goose.honk").setStyle(splashStyle));
        splashTexts.add(Text.translatable("splash.silly-goose.silly_goose").setStyle(splashStyle));
        splashTexts.add(Text.translatable("splash.silly-goose.define").setStyle(splashStyle));
        splashTexts.add(Text.translatable("splash.silly-goose.quack").setStyle(splashStyle));
        splashTexts.add(Text.translatable("splash.silly-goose.duck").setStyle(splashStyle));
        splashTexts.add(Text.translatable("splash.silly-goose.57").setStyle(splashStyle));
        splashTexts.add(Text.translatable("splash.silly-goose.goose_overlords").setStyle(splashStyle));
        splashTexts.add(Text.translatable("splash.silly-goose.untitled_goose_game").setStyle(splashStyle));
        splashTexts.add(Text.translatable("splash.silly-goose.no_geese_allowed").setStyle(splashStyle));
        splashTexts.add(Text.translatable("splash.silly-goose.honking").setStyle(splashStyle));
    }
}