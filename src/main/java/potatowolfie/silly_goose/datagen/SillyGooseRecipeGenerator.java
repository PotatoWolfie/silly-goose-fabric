package potatowolfie.silly_goose.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.registry.RegistryWrapper;
import potatowolfie.silly_goose.item.SillyGooseItems;

import java.util.concurrent.CompletableFuture;

public class SillyGooseRecipeGenerator extends FabricRecipeProvider {
    public SillyGooseRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                offerFoodCookingRecipe("smelting", RecipeSerializer.SMELTING, SmeltingRecipe::new,
                        200, SillyGooseItems.RAW_GOOSE, SillyGooseItems.COOKED_GOOSE, 0.35f);

                offerFoodCookingRecipe("smoking", RecipeSerializer.SMOKING, SmokingRecipe::new,
                        100, SillyGooseItems.RAW_GOOSE, SillyGooseItems.COOKED_GOOSE, 0.35f);

                offerFoodCookingRecipe("campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new,
                        600, SillyGooseItems.RAW_GOOSE, SillyGooseItems.COOKED_GOOSE, 0.35f);
            }
        };
    }

    @Override
    public String getName() {
        return "The one things where you- HONK- craft the things together or smth like that";
    }
}