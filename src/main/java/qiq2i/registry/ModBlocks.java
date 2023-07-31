package qiq2i.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MagmaBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import qiq2i.template.TemplateMod;

public class ModBlocks {
    public static final Block CIRINE_BLOCK = registerBlock("citrine_block",
            new Block(FabricBlockSettings.create().strength(1.0f).requiresTool()),
            ItemGroups.BUILDING_BLOCKS);
    public static final Block CIRINE_ORE = registerBlock("citrine_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.create().strength(1.0f), UniformIntProvider.create(2, 6)),
            ItemGroups.BUILDING_BLOCKS);
    public static final Block DEEPSLATE_CIRINE_ORE = registerBlock("deepslate_citrine_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.create().strength(2.0f), UniformIntProvider.create(2, 6)),
            ItemGroups.BUILDING_BLOCKS);
    public static Block registerBlock(String name, Block block, RegistryKey<ItemGroup>... itemGroups) {
        ModItems.registerItem(name, new BlockItem(block, new FabricItemSettings()), itemGroups);
        return Registry.register(Registries.BLOCK, new Identifier(TemplateMod.Mod_ID, name), block);
    }
    public static  void registerModBlocks() {
        TemplateMod.LOGGER.debug("Registering mod items for" + TemplateMod.Mod_ID);
    }
}
