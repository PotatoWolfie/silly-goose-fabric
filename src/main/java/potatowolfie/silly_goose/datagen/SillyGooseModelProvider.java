package potatowolfie.silly_goose.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import potatowolfie.silly_goose.item.SillyGooseItems;

public class SillyGooseModelProvider extends FabricModelProvider {
    public SillyGooseModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(SillyGooseItems.GOOSE_SPAWN_EGG, Models.GENERATED);
        itemModelGenerator.register(SillyGooseItems.WHITE_EGG, Models.GENERATED);
        itemModelGenerator.register(SillyGooseItems.BIG_WHITE_EGG, Models.GENERATED);
        itemModelGenerator.register(SillyGooseItems.SMALL_WHITE_EGG, Models.GENERATED);
        itemModelGenerator.register(SillyGooseItems.RAW_GOOSE, Models.GENERATED);
        itemModelGenerator.register(SillyGooseItems.COOKED_GOOSE, Models.GENERATED);
    }
}