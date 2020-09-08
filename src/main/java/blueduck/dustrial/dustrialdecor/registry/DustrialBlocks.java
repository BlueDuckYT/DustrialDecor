package blueduck.dustrial.dustrialdecor.registry;

import blueduck.dustrial.dustrialdecor.DustrialDecorMod;
import blueduck.dustrial.dustrialdecor.blocks.*;
import blueduck.dustrial.dustrialdecor.blocks.DirectionalBlock;
import blueduck.dustrial.dustrialdecor.items.CardboardArmor;
import blueduck.dustrial.dustrialdecor.items.CardboardArmorMaterial;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DustrialBlocks {

    public static final SoundType CARDBOARD_SOUND = new SoundType(1.0F, 1.0F, SoundEvents.ITEM_CROP_PLANT, SoundEvents.ITEM_CROP_PLANT, SoundEvents.ITEM_CROP_PLANT, SoundEvents.ITEM_CROP_PLANT, SoundEvents.ITEM_CROP_PLANT);

    public static final CardboardArmorMaterial CARDBOARD_ARMOR_MATERIAL = new CardboardArmorMaterial();

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, DustrialDecorMod.MODID);
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, DustrialDecorMod.MODID);


    public static final RegistryObject<Block> PADDED_BLOCK = BLOCKS.register("padded_block", () -> new PaddedBlock(Block.Properties.create(Material.WOOL, MaterialColor.WHITE_TERRACOTTA).sound(SoundType.CLOTH).hardnessAndResistance(1F, 1F).harvestLevel(0)));
    public static final RegistryObject<Item> PADDED_BLOCK_ITEM = ITEMS.register("padded_block", () -> new BlockItem(PADDED_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> MINI_PADDED_BLOCK = BLOCKS.register("mini_padded_block", () -> new PaddedBlock(Block.Properties.from(PADDED_BLOCK.get())));
    public static final RegistryObject<Item> MINI_PADDED_BLOCK_ITEM = ITEMS.register("mini_padded_block", () -> new BlockItem(MINI_PADDED_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> MINI_PADDED_SLAB = BLOCKS.register("mini_padded_slab", () -> new PaddedSlab(Block.Properties.from(PADDED_BLOCK.get())));
    public static final RegistryObject<Item> MINI_PADDED_SLAB_ITEM = ITEMS.register("mini_padded_slab", () -> new BlockItem(MINI_PADDED_SLAB.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> MINI_PADDED_STAIRS = BLOCKS.register("mini_padded_stairs", () -> new PaddedStairs(Block.Properties.from(PADDED_BLOCK.get())));
    public static final RegistryObject<Item> MINI_PADDED_STAIRS_ITEM = ITEMS.register("mini_padded_stairs", () -> new BlockItem(MINI_PADDED_STAIRS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> PADDED_TRAPDOOR = BLOCKS.register("padded_trapdoor", () -> new DustrialTrapDoor(Block.Properties.from(Blocks.IRON_BLOCK).sound(SoundType.CLOTH)));
    public static final RegistryObject<Item> PADDED_TRAPDOOR_ITEM = ITEMS.register("padded_trapdoor", () -> new BlockItem(PADDED_TRAPDOOR.get(), new Item.Properties().group(ItemGroup.REDSTONE)));

    public static final RegistryObject<Block> PADDED_DOOR = BLOCKS.register("padded_door", () -> new DustrialDoor(Block.Properties.from(PADDED_TRAPDOOR.get())));
    public static final RegistryObject<Item> PADDED_DOOR_ITEM = ITEMS.register("padded_door", () -> new BlockItem(PADDED_DOOR.get(), new Item.Properties().group(ItemGroup.REDSTONE)));

    public static final RegistryObject<Block> CHAIN_LINK_FENCE = BLOCKS.register("chain_link_fence", () -> new DustrialPane(Block.Properties.from(Blocks.IRON_BARS).sound(SoundType.SCAFFOLDING), true, false));
    public static final RegistryObject<Item> CHAIN_LINK_FENCE_ITEM = ITEMS.register("chain_link_fence", () -> new BlockItem(CHAIN_LINK_FENCE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> BARBED_CHAIN_LINK_FENCE = BLOCKS.register("barbed_chain_link_fence", () -> new DustrialPane(Block.Properties.from(Blocks.IRON_BARS).sound(SoundType.SCAFFOLDING), true, true));
    public static final RegistryObject<Item> BARBED_CHAIN_LINK_FENCE_ITEM = ITEMS.register("barbed_chain_link_fence", () -> new BlockItem(BARBED_CHAIN_LINK_FENCE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> BARBED_IRON_BARS = BLOCKS.register("barbed_iron_bars", () -> new DustrialPane(Block.Properties.from(Blocks.IRON_BARS).sound(SoundType.METAL), false, true));
    public static final RegistryObject<Item> BARBED_IRON_BARS_ITEM = ITEMS.register("barbed_iron_bars", () -> new BlockItem(BARBED_IRON_BARS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CHAIN_TRAPDOOR = BLOCKS.register("chain_trapdoor", () -> new DustrialTrapDoor(Block.Properties.create(Material.ROCK).hardnessAndResistance(1F, 1F).sound(SoundType.SCAFFOLDING)));
    public static final RegistryObject<Item> CHAIN_TRAPDOOR_ITEM = ITEMS.register("chain_trapdoor", () -> new BlockItem(CHAIN_TRAPDOOR.get(), new Item.Properties().group(ItemGroup.REDSTONE)));

    public static final RegistryObject<Block> CHAIN_DOOR = BLOCKS.register("chain_door", () -> new DustrialDoor(Block.Properties.from(CHAIN_TRAPDOOR.get())));
    public static final RegistryObject<Item> CHAIN_DOOR_ITEM = ITEMS.register("chain_door", () -> new BlockItem(CHAIN_DOOR.get(), new Item.Properties().group(ItemGroup.REDSTONE)));

    public static final RegistryObject<Block> INDUSTRIAL_IRON_BLOCK = BLOCKS.register("industrial_iron_block", () -> new Block(Block.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Item> INDUSTRIAL_IRON_BLOCK_ITEM = ITEMS.register("industrial_iron_block", () -> new BlockItem(INDUSTRIAL_IRON_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> INDUSTRIAL_IRON_PILLAR_BLOCK = BLOCKS.register("industrial_iron_pillar", () -> new RotatedPillarBlock(Block.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Item> INDUSTRIAL_IRON_PILLAR_BLOCK_ITEM = ITEMS.register("industrial_iron_pillar", () -> new BlockItem(INDUSTRIAL_IRON_PILLAR_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> BOLTED_INDUSTRIAL_IRON_BLOCK = BLOCKS.register("bolted_industrial_iron_block", () -> new Block(Block.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Item> BOLTED_INDUSTRIAL_IRON_BLOCK_ITEM = ITEMS.register("bolted_industrial_iron_block", () -> new BlockItem(BOLTED_INDUSTRIAL_IRON_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> BOLTED_INDUSTRIAL_IRON_SLAB = BLOCKS.register("bolted_industrial_iron_slab", () -> new SlabBlock(Block.Properties.from(BOLTED_INDUSTRIAL_IRON_BLOCK.get())));
    public static final RegistryObject<Item> BOLTED_INDUSTRIAL_IRON_SLAB_ITEM = ITEMS.register("bolted_industrial_iron_slab", () -> new BlockItem(BOLTED_INDUSTRIAL_IRON_SLAB.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> BOLTED_INDUSTRIAL_IRON_STAIRS = BLOCKS.register("bolted_industrial_iron_stairs", () -> new StairsBlock(() -> BOLTED_INDUSTRIAL_IRON_BLOCK.get().getDefaultState(), Block.Properties.from(BOLTED_INDUSTRIAL_IRON_BLOCK.get())));
    public static final RegistryObject<Item> BOLTED_INDUSTRIAL_IRON_STAIRS_ITEM = ITEMS.register("bolted_industrial_iron_stairs", () -> new BlockItem(BOLTED_INDUSTRIAL_IRON_STAIRS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> INDUSTRIAL_IRON_TRAPDOOR = BLOCKS.register("industrial_iron_trapdoor", () -> new DustrialTrapDoor(Block.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Item> INDUSTRIAL_IRON_TRAPDOOR_ITEM = ITEMS.register("industrial_iron_trapdoor", () -> new BlockItem(INDUSTRIAL_IRON_TRAPDOOR.get(), new Item.Properties().group(ItemGroup.REDSTONE)));

    public static final RegistryObject<Block> INDUSTRIAL_IRON_DOOR = BLOCKS.register("industrial_iron_door", () -> new DustrialDoor(Block.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Item> INDUSTRIAL_IRON_DOOR_ITEM = ITEMS.register("industrial_iron_door", () -> new BlockItem(INDUSTRIAL_IRON_DOOR.get(), new Item.Properties().group(ItemGroup.REDSTONE)));

    public static final RegistryObject<Item> SHEET_METAL = ITEMS.register("sheet_metal", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    public static final RegistryObject<Block> SHEET_METAL_PLATING = BLOCKS.register("sheet_metal_plating", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.5F).sound(SoundType.METAL)));
    public static final RegistryObject<Item> SHEET_METAL_PLATING_ITEM = ITEMS.register("sheet_metal_plating", () -> new BlockItem(SHEET_METAL_PLATING.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_PLATING_SLAB = BLOCKS.register("sheet_metal_plating_slab", () -> new SlabBlock(Block.Properties.from(SHEET_METAL_PLATING.get())));
    public static final RegistryObject<Item> SHEET_METAL_PLATING_SLAB_ITEM = ITEMS.register("sheet_metal_plating_slab", () -> new BlockItem(SHEET_METAL_PLATING_SLAB.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_PLATING_STAIRS = BLOCKS.register("sheet_metal_plating_stairs", () -> new StairsBlock(() -> SHEET_METAL_PLATING.get().getDefaultState(), Block.Properties.from(SHEET_METAL_PLATING.get())));
    public static final RegistryObject<Item> SHEET_METAL_PLATING_STAIRS_ITEM = ITEMS.register("sheet_metal_plating_stairs", () -> new BlockItem(SHEET_METAL_PLATING_STAIRS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_PANELING = BLOCKS.register("sheet_metal_paneling", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.5F).sound(SoundType.METAL)));
    public static final RegistryObject<Item> SHEET_METAL_PANELING_ITEM = ITEMS.register("sheet_metal_paneling", () -> new BlockItem(SHEET_METAL_PANELING.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_SIDING = BLOCKS.register("sheet_metal_siding", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.5F).sound(SoundType.METAL)));
    public static final RegistryObject<Item> SHEET_METAL_SIDING_ITEM = ITEMS.register("sheet_metal_siding", () -> new BlockItem(SHEET_METAL_SIDING.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_WALLING = BLOCKS.register("sheet_metal_walling", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.5F).sound(SoundType.METAL)));
    public static final RegistryObject<Item> SHEET_METAL_WALLING_ITEM = ITEMS.register("sheet_metal_walling", () -> new BlockItem(SHEET_METAL_WALLING.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_TREADING = BLOCKS.register("sheet_metal_treading", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.5F).sound(SoundType.METAL)));
    public static final RegistryObject<Item> SHEET_METAL_TREADING_ITEM = ITEMS.register("sheet_metal_treading", () -> new BlockItem(SHEET_METAL_TREADING.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_TREADING_SLAB = BLOCKS.register("sheet_metal_treading_slab", () -> new SlabBlock(Block.Properties.from(SHEET_METAL_TREADING.get())));
    public static final RegistryObject<Item> SHEET_METAL_TREADING_SLAB_ITEM = ITEMS.register("sheet_metal_treading_slab", () -> new BlockItem(SHEET_METAL_TREADING_SLAB.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_TREADING_STAIRS = BLOCKS.register("sheet_metal_treading_stairs", () -> new StairsBlock(() -> SHEET_METAL_TREADING.get().getDefaultState(), Block.Properties.from(SHEET_METAL_TREADING.get())));
    public static final RegistryObject<Item> SHEET_METAL_TREADING_STAIRS_ITEM = ITEMS.register("sheet_metal_treading_stairs", () -> new BlockItem(SHEET_METAL_TREADING_STAIRS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_TRAPDOOR = BLOCKS.register("sheet_metal_trapdoor", () -> new DustrialTrapDoor(Block.Properties.create(Material.ROCK).hardnessAndResistance(1F, 1F).sound(SoundType.METAL)));
    public static final RegistryObject<Item> SHEET_METAL_TRAPDOOR_ITEM = ITEMS.register("sheet_metal_trapdoor", () -> new BlockItem(SHEET_METAL_TRAPDOOR.get(), new Item.Properties().group(ItemGroup.REDSTONE)));

    public static final RegistryObject<Block> SHEET_METAL_DOOR = BLOCKS.register("sheet_metal_door", () -> new DustrialDoor(Block.Properties.from(SHEET_METAL_TRAPDOOR.get())));
    public static final RegistryObject<Item> SHEET_METAL_DOOR_ITEM = ITEMS.register("sheet_metal_door", () -> new BlockItem(SHEET_METAL_DOOR.get(), new Item.Properties().group(ItemGroup.REDSTONE)));

    public static final RegistryObject<Item> RUSTY_SHEET_METAL = ITEMS.register("rusty_sheet_metal", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_PLATING = BLOCKS.register("rusty_sheet_metal_plating", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.5F).sound(SoundType.METAL)));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_PLATING_ITEM = ITEMS.register("rusty_sheet_metal_plating", () -> new BlockItem(RUSTY_SHEET_METAL_PLATING.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_PLATING_SLAB = BLOCKS.register("rusty_sheet_metal_plating_slab", () -> new SlabBlock(Block.Properties.from(RUSTY_SHEET_METAL_PLATING.get())));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_PLATING_SLAB_ITEM = ITEMS.register("rusty_sheet_metal_plating_slab", () -> new BlockItem(RUSTY_SHEET_METAL_PLATING_SLAB.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_PLATING_STAIRS = BLOCKS.register("rusty_sheet_metal_plating_stairs", () -> new StairsBlock(() -> RUSTY_SHEET_METAL_PLATING.get().getDefaultState(), Block.Properties.from(RUSTY_SHEET_METAL_PLATING.get())));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_PLATING_STAIRS_ITEM = ITEMS.register("rusty_sheet_metal_plating_stairs", () -> new BlockItem(RUSTY_SHEET_METAL_PLATING_STAIRS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_PANELING = BLOCKS.register("rusty_sheet_metal_paneling", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.5F).sound(SoundType.METAL)));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_PANELING_ITEM = ITEMS.register("rusty_sheet_metal_paneling", () -> new BlockItem(RUSTY_SHEET_METAL_PANELING.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_SIDING = BLOCKS.register("rusty_sheet_metal_siding", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.5F).sound(SoundType.METAL)));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_SIDING_ITEM = ITEMS.register("rusty_sheet_metal_siding", () -> new BlockItem(RUSTY_SHEET_METAL_SIDING.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_WALLING = BLOCKS.register("rusty_sheet_metal_walling", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.5F).sound(SoundType.METAL)));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_WALLING_ITEM = ITEMS.register("rusty_sheet_metal_walling", () -> new BlockItem(RUSTY_SHEET_METAL_WALLING.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_TREADING = BLOCKS.register("rusty_sheet_metal_treading", () -> new Block(Block.Properties.create(Material.IRON, MaterialColor.IRON).hardnessAndResistance(3.0F, 3.5F).sound(SoundType.METAL)));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_TREADING_ITEM = ITEMS.register("rusty_sheet_metal_treading", () -> new BlockItem(RUSTY_SHEET_METAL_TREADING.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_TREADING_SLAB = BLOCKS.register("rusty_sheet_metal_treading_slab", () -> new SlabBlock(Block.Properties.from(RUSTY_SHEET_METAL_TREADING.get())));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_TREADING_SLAB_ITEM = ITEMS.register("rusty_sheet_metal_treading_slab", () -> new BlockItem(RUSTY_SHEET_METAL_TREADING_SLAB.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_TREADING_STAIRS = BLOCKS.register("rusty_sheet_metal_treading_stairs", () -> new StairsBlock(() -> RUSTY_SHEET_METAL_TREADING.get().getDefaultState(), Block.Properties.from(RUSTY_SHEET_METAL_TREADING.get())));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_TREADING_STAIRS_ITEM = ITEMS.register("rusty_sheet_metal_treading_stairs", () -> new BlockItem(RUSTY_SHEET_METAL_TREADING_STAIRS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_TRAPDOOR = BLOCKS.register("rusty_sheet_metal_trapdoor", () -> new DustrialTrapDoor(Block.Properties.create(Material.ROCK).hardnessAndResistance(1F, 1F).sound(SoundType.METAL)));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_TRAPDOOR_ITEM = ITEMS.register("rusty_sheet_metal_trapdoor", () -> new BlockItem(RUSTY_SHEET_METAL_TRAPDOOR.get(), new Item.Properties().group(ItemGroup.REDSTONE)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_DOOR = BLOCKS.register("rusty_sheet_metal_door", () -> new DustrialDoor(Block.Properties.from(RUSTY_SHEET_METAL_TRAPDOOR.get())));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_DOOR_ITEM = ITEMS.register("rusty_sheet_metal_door", () -> new BlockItem(RUSTY_SHEET_METAL_DOOR.get(), new Item.Properties().group(ItemGroup.REDSTONE)));

    public static final RegistryObject<Block> CINDER_BLOCK = BLOCKS.register("cinder_block", () -> new CinderBlock(Block.Properties.from(Blocks.STONE)));
    public static final RegistryObject<Item> CINDER_BLOCK_ITEM = ITEMS.register("cinder_block", () -> new BlockItem(CINDER_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> POLISHED_CINDER_BLOCK = BLOCKS.register("polished_cinder_block", () -> new CinderBlock(Block.Properties.from(Blocks.STONE)));
    public static final RegistryObject<Item> POLISHED_CINDER_BLOCK_ITEM = ITEMS.register("polished_cinder_block", () -> new BlockItem(POLISHED_CINDER_BLOCK.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CINDER_BRICKS = BLOCKS.register("cinder_bricks", () -> new Block(Block.Properties.from(Blocks.STONE)));
    public static final RegistryObject<Item> CINDER_BRICKS_ITEM = ITEMS.register("cinder_bricks", () -> new BlockItem(CINDER_BRICKS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CINDER_BRICKS_SLAB = BLOCKS.register("cinder_brick_slab", () -> new SlabBlock(Block.Properties.from(CINDER_BRICKS.get())));
    public static final RegistryObject<Item> CINDER_BRICKS_SLAB_ITEM = ITEMS.register("cinder_brick_slab", () -> new BlockItem(CINDER_BRICKS_SLAB.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CINDER_BRICKS_STAIRS = BLOCKS.register("cinder_brick_stairs", () -> new StairsBlock(() -> CINDER_BRICKS.get().getDefaultState(), Block.Properties.from(CINDER_BRICKS.get())));
    public static final RegistryObject<Item> CINDER_BRICKS_STAIRS_ITEM = ITEMS.register("cinder_brick_stairs", () -> new BlockItem(CINDER_BRICKS_STAIRS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Item> CARDBOARD = ITEMS.register("cardboard", () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS)));

    public static final RegistryObject<Block> CARDBOARD_BOX = BLOCKS.register("cardboard_box", () -> new DirectionalBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.WOOD).hardnessAndResistance(1.0F, 0.3F).sound(CARDBOARD_SOUND).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Item> CARDBOARD_BOX_ITEM = ITEMS.register("cardboard_box", () -> new BlockItem(CARDBOARD_BOX.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SMOOTH_CARDBOARD = BLOCKS.register("smooth_cardboard", () -> new CardboardBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.WOOD).hardnessAndResistance(1.0F, 0.3F).sound(CARDBOARD_SOUND).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Item> SMOOTH_CARDBOARD_ITEM = ITEMS.register("smooth_cardboard", () -> new BlockItem(SMOOTH_CARDBOARD.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SMOOTH_CARDBOARD_SLAB = BLOCKS.register("smooth_cardboard_slab", () -> new CardboardSlab(Block.Properties.from(SMOOTH_CARDBOARD.get())));
    public static final RegistryObject<Item> SMOOTH_CARDBOARD_SLAB_ITEM = ITEMS.register("smooth_cardboard_slab", () -> new BlockItem(SMOOTH_CARDBOARD_SLAB.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SMOOTH_CARDBOARD_STAIRS = BLOCKS.register("smooth_cardboard_stairs", () -> new CardboardStairs(Block.Properties.from(SMOOTH_CARDBOARD.get())));
    public static final RegistryObject<Item> SMOOTH_CARDBOARD_STAIRS_ITEM = ITEMS.register("smooth_cardboard_stairs", () -> new BlockItem(SMOOTH_CARDBOARD_STAIRS.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> FOLDED_CARDBOARD = BLOCKS.register("folded_cardboard", () -> new CardboardBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.WOOD).hardnessAndResistance(1.0F, 0.3F).sound(CARDBOARD_SOUND).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Item> FOLDED_CARDBOARD_ITEM = ITEMS.register("folded_cardboard", () -> new BlockItem(FOLDED_CARDBOARD.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CARDBOARD_SCRAP = BLOCKS.register("cardboard_scrap", () -> new CardboardBlock(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.WOOD).hardnessAndResistance(1.0F, 0.3F).sound(CARDBOARD_SOUND).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Item> CARDBOARD_SCRAP_ITEM = ITEMS.register("cardboard_scrap", () -> new BlockItem(CARDBOARD_SCRAP.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CARDBOARD_TRAPDOOR = BLOCKS.register("cardboard_trapdoor", () -> new DustrialTrapDoor(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.WOOD).hardnessAndResistance(1.0F, 0.3F).sound(CARDBOARD_SOUND).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Item> CARDBOARD_TRAPDOOR_ITEM = ITEMS.register("cardboard_trapdoor", () -> new BlockItem(CARDBOARD_TRAPDOOR.get(), new Item.Properties().group(ItemGroup.REDSTONE)));

    public static final RegistryObject<Block> CARDBOARD_DOOR = BLOCKS.register("cardboard_door", () -> new DustrialDoor(Block.Properties.from(CARDBOARD_TRAPDOOR.get())));
    public static final RegistryObject<Item> CARDBOARD_DOOR_ITEM = ITEMS.register("cardboard_door", () -> new BlockItem(CARDBOARD_DOOR.get(), new Item.Properties().group(ItemGroup.REDSTONE)));

    public static final RegistryObject<Item> CARDBOARD_HELMET = ITEMS.register("cardboard_helmet", () -> new CardboardArmor(CARDBOARD_ARMOR_MATERIAL, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> CARDBOARD_CHESTPLATE = ITEMS.register("cardboard_chestplate", () -> new CardboardArmor(CARDBOARD_ARMOR_MATERIAL, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> CARDBOARD_LEGGINGS = ITEMS.register("cardboard_leggings", () -> new CardboardArmor(CARDBOARD_ARMOR_MATERIAL, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
    public static final RegistryObject<Item> CARDBOARD_BOOTS = ITEMS.register("cardboard_boots", () -> new CardboardArmor(CARDBOARD_ARMOR_MATERIAL, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Block> METAL_SCAFFOLDING = BLOCKS.register("metal_scaffolding", () -> new MetalScaffolding(Block.Properties.from(Blocks.IRON_BLOCK)));
    //public static final RegistryObject<Item> METAL_SCAFFOLDING_ITEM = ITEMS.register("metal_scaffolding", () -> new MetalScaffoldingItem(METAL_SCAFFOLDING.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));



    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
