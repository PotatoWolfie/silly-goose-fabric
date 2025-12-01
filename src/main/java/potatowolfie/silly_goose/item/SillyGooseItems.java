package potatowolfie.silly_goose.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.LazyRegistryEntryReference;
import net.minecraft.util.Identifier;
import potatowolfie.silly_goose.SillyGoose;
import potatowolfie.silly_goose.entity.SillyGooseEntities;
import potatowolfie.silly_goose.entity.goose.variant.GooseVariants;
import potatowolfie.silly_goose.item.custom.BigGooseEggItem;
import potatowolfie.silly_goose.item.custom.GooseEggItem;
import potatowolfie.silly_goose.item.custom.SmallGooseEggItem;
import potatowolfie.silly_goose.registry.SillyGooseDataComponentTypes;

public class SillyGooseItems {
    public static final Item GOOSE_SPAWN_EGG = registerItem("goose_spawn_egg",
            new SpawnEggItem(new Item.Settings().spawnEgg(SillyGooseEntities.GOOSE)
                            .registryKey(createItemRegistryKey("goose_spawn_egg"))));

    public static final Item WHITE_EGG = registerItem("white_egg",
            new GooseEggItem(new Item.Settings().maxCount(16)
                    .component(SillyGooseDataComponentTypes.GOOSE_VARIANT,
                            new LazyRegistryEntryReference<>(GooseVariants.TEMPERATE))
                    .registryKey(createItemRegistryKey("white_egg"))));

    public static final Item BIG_WHITE_EGG = registerItem("big_white_egg",
            new BigGooseEggItem(new Item.Settings().maxCount(16)
                    .component(SillyGooseDataComponentTypes.GOOSE_VARIANT,
                            new LazyRegistryEntryReference<>(GooseVariants.COLD))
                    .registryKey(createItemRegistryKey("big_white_egg"))));

    public static final Item SMALL_WHITE_EGG = registerItem("small_white_egg",
            new SmallGooseEggItem(new Item.Settings().maxCount(16)
                    .component(SillyGooseDataComponentTypes.GOOSE_VARIANT,
                            new LazyRegistryEntryReference<>(GooseVariants.WARM))
                    .registryKey(createItemRegistryKey("small_white_egg"))));

    public static final Item RAW_GOOSE = registerItem("raw_goose",
            new Item(new Item.Settings()
                    .food(new FoodComponent.Builder()
                            .nutrition(3)
                            .saturationModifier(0.4f)
                            .build())
                    .registryKey(createItemRegistryKey("raw_goose"))));

    public static final Item COOKED_GOOSE = registerItem("cooked_goose",
            new Item(new Item.Settings()
                    .food(new FoodComponent.Builder()
                            .nutrition(7)
                            .saturationModifier(0.8f)
                            .build())
                    .registryKey(createItemRegistryKey("cooked_goose"))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, createItemRegistryKey(name), item);
    }

    private static RegistryKey<Item> createItemRegistryKey(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SillyGoose.MOD_ID, name));
    }

    private static void customSpawnEggs(FabricItemGroupEntries entries) {
        entries.addAfter(Items.CHICKEN_SPAWN_EGG, GOOSE_SPAWN_EGG);
    }
    private static void customCombat(FabricItemGroupEntries entries) {
        entries.addAfter(Items.BLUE_EGG, WHITE_EGG);
        entries.addAfter(WHITE_EGG, BIG_WHITE_EGG);
        entries.addAfter(BIG_WHITE_EGG, SMALL_WHITE_EGG);
    }
    private static void customIngredients(FabricItemGroupEntries entries) {
        entries.addAfter(Items.BLUE_EGG, WHITE_EGG);
        entries.addAfter(WHITE_EGG, BIG_WHITE_EGG);
        entries.addAfter(BIG_WHITE_EGG, SMALL_WHITE_EGG);
    }

    private static void customFood(FabricItemGroupEntries entries) {
        entries.addAfter(Items.COOKED_CHICKEN, RAW_GOOSE);
        entries.addAfter(RAW_GOOSE, COOKED_GOOSE);
    }

    public static void registerModItems() {
        SillyGoose.LOGGER.info("Registering goose-related Items for " + SillyGoose.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(SillyGooseItems::customSpawnEggs);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(SillyGooseItems::customCombat);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(SillyGooseItems::customIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(SillyGooseItems::customFood);
    }
}
