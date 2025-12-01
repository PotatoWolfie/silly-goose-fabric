package potatowolfie.silly_goose;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import potatowolfie.silly_goose.entity.SillyGooseEntities;
import potatowolfie.silly_goose.entity.client.SillyGooseEntityModelLayers;
import potatowolfie.silly_goose.entity.goose.GooseEntityRenderer;
import potatowolfie.silly_goose.entity.goose.GooseEntityModel;

public class SillyGooseClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityModelLayerRegistry.registerModelLayer(
                SillyGooseEntityModelLayers.GOOSE,
                GooseEntityModel::getTexturedModelData
        );
        EntityModelLayerRegistry.registerModelLayer(
                SillyGooseEntityModelLayers.BABY_GOOSE,
                () -> GooseEntityModel.getTexturedModelData().transform(GooseEntityModel.BABY_TRANSFORMER)
        );
        EntityRendererRegistry.register(SillyGooseEntities.GOOSE, GooseEntityRenderer::new);
        EntityRendererRegistry.register(SillyGooseEntities.WHITE_EGG, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(SillyGooseEntities.BIG_WHITE_EGG, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(SillyGooseEntities.SMALL_WHITE_EGG, FlyingItemEntityRenderer::new);

    }
}