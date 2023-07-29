package qiq2i.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import qiq2i.template.TemplateMod;

public class ModItems {

    public static final Item CITRINE = registerItem("citrine",
            new Item(new FabricItemSettings()),
            ItemGroups.BUILDING_BLOCKS);//这里只能写ItemGroups里已经有的物品组分类。
    public static final Item RAW_CITRINE = registerItem("raw_citrine",
            new Item(new FabricItemSettings()),
            ItemGroups.BUILDING_BLOCKS);
    public static Item registerItem(String name, Item item, RegistryKey<ItemGroup>... itemGroups) {
        Item registeredItem = Registry.register(Registries.ITEM, new Identifier(TemplateMod.Mod_ID, name),item);
        for (RegistryKey<ItemGroup> itemGroup: itemGroups) {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(registeredItem));
        }
        return registeredItem;
    }
    public static void registerModItems() {
        TemplateMod.LOGGER.debug("Registering mod items for" + TemplateMod.Mod_ID);
    }

}
