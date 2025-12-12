package potatowolfie.silly_goose.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import potatowolfie.silly_goose.item.SillyGooseItems;
import potatowolfie.silly_goose.registry.SillyGooseItemTags;

import java.util.concurrent.CompletableFuture;

public class SillyGooseItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public SillyGooseItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ItemTags.WOLF_FOOD)
                .add(SillyGooseItems.RAW_GOOSE)
                .add(SillyGooseItems.COOKED_GOOSE);

        valueLookupBuilder(ItemTags.MEAT)
                .add(SillyGooseItems.RAW_GOOSE)
                .add(SillyGooseItems.COOKED_GOOSE);

        valueLookupBuilder(SillyGooseItemTags.Item.GOOSE_EGGS)
                .add(SillyGooseItems.WHITE_EGG)
                .add(SillyGooseItems.BIG_WHITE_EGG)
                .add(SillyGooseItems.SMALL_WHITE_EGG);
    }
}
