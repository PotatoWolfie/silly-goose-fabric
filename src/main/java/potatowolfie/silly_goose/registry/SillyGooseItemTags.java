package potatowolfie.silly_goose.registry;

import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import potatowolfie.silly_goose.SillyGoose;

public class SillyGooseItemTags {
    public static class Item {
        public static final TagKey<net.minecraft.item.Item> GOOSE_EGGS = createTag("goose_eggs");

        private static TagKey<net.minecraft.item.Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(SillyGoose.MOD_ID, name));
        }
    }
}