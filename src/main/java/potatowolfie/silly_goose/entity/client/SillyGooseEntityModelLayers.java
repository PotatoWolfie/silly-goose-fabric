package potatowolfie.silly_goose.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import potatowolfie.silly_goose.SillyGoose;

public class SillyGooseEntityModelLayers {

    public static final EntityModelLayer GOOSE =
            new EntityModelLayer(Identifier.of(SillyGoose.MOD_ID, "goose"), "main");
    public static final EntityModelLayer BABY_GOOSE =
            new EntityModelLayer(Identifier.of(SillyGoose.MOD_ID, "baby_goose"), "main");
}