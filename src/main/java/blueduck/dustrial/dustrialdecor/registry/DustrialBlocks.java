package blueduck.dustrial.dustrialdecor.registry;

import blueduck.dustrial.dustrialdecor.DustrialDecorMod;
import blueduck.dustrial.dustrialdecor.blocks.DustrialPane;
import blueduck.dustrial.dustrialdecor.blocks.DustrialTrapDoor;
import blueduck.dustrial.dustrialdecor.blocks.PaddedBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DustrialBlocks {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, DustrialDecorMod.MODID);
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, DustrialDecorMod.MODID);


    public static final RegistryObject<Block> PADDED_BLOCK = BLOCKS.register("padded_block", () -> new PaddedBlock(Block.Properties.create(Material.WOOL, MaterialColor.WHITE_TERRACOTTA).sound(SoundType.CLOTH).hardnessAndResistance(1F, 1F).harvestLevel(0)));
    public static final RegistryObject<Item> PADDED_BLOCK_ITEM = ITEMS.register("padded_block", () -> new BlockItem(PADDED_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> MINI_PADDED_BLOCK = BLOCKS.register("mini_padded_block", () -> new PaddedBlock(Block.Properties.from(PADDED_BLOCK.get())));
    public static final RegistryObject<Item> MINI_PADDED_BLOCK_ITEM = ITEMS.register("mini_padded_block", () -> new BlockItem(MINI_PADDED_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> PADDED_TRAPDOOR = BLOCKS.register("padded_trapdoor", () -> new DustrialTrapDoor(Block.Properties.from(Blocks.IRON_BLOCK).sound(SoundType.CLOTH)));
    public static final RegistryObject<Item> PADDED_TRAPDOOR_ITEM = ITEMS.register("padded_trapdoor", () -> new BlockItem(PADDED_TRAPDOOR.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CHAIN_LINK_FENCE = BLOCKS.register("chain_link_fence", () -> new DustrialPane(Block.Properties.from(Blocks.IRON_BARS).sound(SoundType.SCAFFOLDING), true, false));
    public static final RegistryObject<Item> CHAIN_LINK_FENCE_ITEM = ITEMS.register("chain_link_fence", () -> new BlockItem(CHAIN_LINK_FENCE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> BARBED_CHAIN_LINK_FENCE = BLOCKS.register("barbed_chain_link_fence", () -> new DustrialPane(Block.Properties.from(Blocks.IRON_BARS).sound(SoundType.SCAFFOLDING), true, true));
    public static final RegistryObject<Item> BARBED_CHAIN_LINK_FENCE_ITEM = ITEMS.register("barbed_chain_link_fence", () -> new BlockItem(BARBED_CHAIN_LINK_FENCE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> BARBED_IRON_BARS = BLOCKS.register("barbed_iron_bars", () -> new DustrialPane(Block.Properties.from(Blocks.IRON_BARS).sound(SoundType.METAL), false, true));
    public static final RegistryObject<Item> BARBED_IRON_BARS_ITEM = ITEMS.register("barbed_iron_bars", () -> new BlockItem(BARBED_IRON_BARS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CHAIN_TRAPDOOR = BLOCKS.register("chain_trapdoor", () -> new DustrialTrapDoor(Block.Properties.create(Material.ROCK).hardnessAndResistance(1F, 1F).sound(SoundType.SCAFFOLDING)));
    public static final RegistryObject<Item> CHAIN_TRAPDOOR_ITEM = ITEMS.register("chain_trapdoor", () -> new BlockItem(CHAIN_TRAPDOOR.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> INDUSTRIAL_IRON_BLOCK = BLOCKS.register("industrial_iron_block", () -> new Block(Block.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Item> INDUSTRIAL_IRON_BLOCK_ITEM = ITEMS.register("industrial_iron_block", () -> new BlockItem(INDUSTRIAL_IRON_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> INDUSTRIAL_IRON_PILLAR_BLOCK = BLOCKS.register("industrial_iron_pillar", () -> new RotatedPillarBlock(Block.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Item> INDUSTRIAL_IRON_PILLAR_BLOCK_ITEM = ITEMS.register("industrial_iron_pillar", () -> new BlockItem(INDUSTRIAL_IRON_PILLAR_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> BOLTED_INDUSTRIAL_IRON_BLOCK = BLOCKS.register("bolted_industrial_iron_block", () -> new Block(Block.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Item> BOLTED_INDUSTRIAL_IRON_BLOCK_ITEM = ITEMS.register("bolted_industrial_iron_block", () -> new BlockItem(BOLTED_INDUSTRIAL_IRON_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> INDUSTRIAL_IRON_TRAPDOOR = BLOCKS.register("industrial_iron_trapdoor", () -> new DustrialTrapDoor(Block.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Item> INDUSTRIAL_IRON_TRAPDOOR_ITEM = ITEMS.register("industrial_iron_trapdoor", () -> new BlockItem(INDUSTRIAL_IRON_TRAPDOOR.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));


    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
