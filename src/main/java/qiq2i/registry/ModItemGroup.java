package qiq2i.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import qiq2i.template.TemplateMod;

public class ModItemGroup {
    //这里构建一个注册物品组所需的RegistryKey
    public static RegistryKey<ItemGroup> TEMPLATEMOD = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(TemplateMod.Mod_ID));
    public static void registerItemGroup() {
        //注册物品组
        Registry.register(Registries.ITEM_GROUP, TEMPLATEMOD, ItemGroup.create(ItemGroup.Row.TOP,3)
                //显示的物品组名称
                .displayName(Text.translatable("itemgroup.template-mod.citrine"))
                //物品组图标
                .icon(() -> new ItemStack(ModItems.CITRINE))
                //添加物品到物品组栏里
                .entries((displayContext, entries) -> {
                    entries.add(ModItems.CITRINE);
                    entries.add(ModItems.RAW_CITRINE);
                }).build());
    }
    public static  void registerModItemGroup() {
        //调用完成创建
        registerItemGroup();
        TemplateMod.LOGGER.debug("Registering mod item group for " + TemplateMod.Mod_ID);
    }
}
