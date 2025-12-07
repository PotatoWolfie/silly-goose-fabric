package potatowolfie.silly_goose.entity.goose;

import com.google.common.collect.Maps;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.model.BabyModelPair;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.entity.state.ArmedEntityRenderState;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.texture.MissingSprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import potatowolfie.silly_goose.entity.client.SillyGooseEntityModelLayers;
import potatowolfie.silly_goose.entity.goose.variant.GooseVariant;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class GooseEntityRenderer extends MobEntityRenderer<GooseEntity, GooseEntityRenderState, GooseEntityModel> {
    private final Map<GooseVariant.Model, BabyModelPair<GooseEntityModel>> babyModelPairMap;
    private final ItemModelManager itemModelManager;

    public GooseEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new GooseEntityModel(context.getPart(SillyGooseEntityModelLayers.GOOSE)), 0.7F);
        this.babyModelPairMap = createBabyModelPairMap(context);
        this.itemModelManager = context.getItemModelManager();

        this.addFeature(new HeldItemFeatureRenderer<>(this));
    }

    private static Map<GooseVariant.Model, BabyModelPair<GooseEntityModel>> createBabyModelPairMap(EntityRendererFactory.Context context) {
        return Maps.newEnumMap(Map.of(
                GooseVariant.Model.NORMAL, new BabyModelPair<>(
                        new GooseEntityModel(context.getPart(SillyGooseEntityModelLayers.GOOSE)),
                        new GooseEntityModel(context.getPart(SillyGooseEntityModelLayers.BABY_GOOSE))
                ),
                GooseVariant.Model.WARM, new BabyModelPair<>(
                        new GooseEntityModel(context.getPart(SillyGooseEntityModelLayers.GOOSE)),
                        new GooseEntityModel(context.getPart(SillyGooseEntityModelLayers.BABY_GOOSE))
                ),
                GooseVariant.Model.COLD, new BabyModelPair<>(
                        new GooseEntityModel(context.getPart(SillyGooseEntityModelLayers.GOOSE)),
                        new GooseEntityModel(context.getPart(SillyGooseEntityModelLayers.BABY_GOOSE))
                )
        ));
    }

    public Identifier getTexture(GooseEntityRenderState gooseEntityRenderState) {
        return gooseEntityRenderState.variant == null ? MissingSprite.getMissingSpriteId() : gooseEntityRenderState.variant.modelAndTexture().asset().texturePath();
    }

    public GooseEntityRenderState createRenderState() {
        return new GooseEntityRenderState();
    }

    public void updateRenderState(GooseEntity gooseEntity, GooseEntityRenderState gooseEntityRenderState, float f) {
        super.updateRenderState(gooseEntity, gooseEntityRenderState, f);
        ArmedEntityRenderState.updateRenderState(gooseEntity, gooseEntityRenderState, this.itemModelManager, f);
        gooseEntityRenderState.variant = (GooseVariant)gooseEntity.getVariant().value();

        gooseEntityRenderState.idleAnimationState.copyFrom(gooseEntity.idleAnimationState);
        gooseEntityRenderState.idleWaterAnimationState.copyFrom(gooseEntity.idleWaterAnimationState);
        gooseEntityRenderState.walkAnimationState.copyFrom(gooseEntity.walkAnimationState);
        gooseEntityRenderState.runAnimationState.copyFrom(gooseEntity.runAnimationState);
        gooseEntityRenderState.swimAnimationState.copyFrom(gooseEntity.swimAnimationState);
        gooseEntityRenderState.swimFastAnimationState.copyFrom(gooseEntity.swimFastAnimationState);
    }

    public void render(GooseEntityRenderState gooseEntityRenderState, MatrixStack matrixStack, OrderedRenderCommandQueue orderedRenderCommandQueue, CameraRenderState cameraRenderState) {
        if (gooseEntityRenderState.variant != null) {
            this.model = (GooseEntityModel)((BabyModelPair)this.babyModelPairMap.get(gooseEntityRenderState.variant.modelAndTexture().model())).get(gooseEntityRenderState.baby);
            super.render(gooseEntityRenderState, matrixStack, orderedRenderCommandQueue, cameraRenderState);
        }
    }
}