package blueduck.dustrial.dustrialdecor.registry;

import blueduck.dustrial.dustrialdecor.DustrialDecorMod;
import blueduck.dustrial.dustrialdecor.blocks.*;
import blueduck.dustrial.dustrialdecor.blocks.DirectionalBlock;
import blueduck.dustrial.dustrialdecor.items.CardboardArmor;
import blueduck.dustrial.dustrialdecor.items.CardboardArmorMaterial;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;

public class DustrialBlocks {

    public static final SoundType CARDBOARD_SOUND = new SoundType(1.0F, 1.0F, SoundEvents.CROP_PLANTED, SoundEvents.CROP_PLANTED, SoundEvents.CROP_PLANTED, SoundEvents.CROP_PLANTED, SoundEvents.CROP_PLANTED);

    public static final CardboardArmorMaterial CARDBOARD_ARMOR_MATERIAL = new CardboardArmorMaterial();

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DustrialDecorMod.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DustrialDecorMod.MODID);


    public static final RegistryObject<Block> PADDED_BLOCK = BLOCKS.register("padded_block", () -> new PaddedBlock(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.TERRACOTTA_WHITE).sound(SoundType.WOOL).strength(1F, 1F)));
    public static final RegistryObject<Item> PADDED_BLOCK_ITEM = ITEMS.register("padded_block", () -> new BlockItem(PADDED_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> MINI_PADDED_BLOCK = BLOCKS.register("mini_padded_block", () -> new PaddedBlock(BlockBehaviour.Properties.copy(PADDED_BLOCK.get())));
    public static final RegistryObject<Item> MINI_PADDED_BLOCK_ITEM = ITEMS.register("mini_padded_block", () -> new BlockItem(MINI_PADDED_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> MINI_PADDED_SLAB = BLOCKS.register("mini_padded_slab", () -> new PaddedSlab(BlockBehaviour.Properties.copy(PADDED_BLOCK.get())));
    public static final RegistryObject<Item> MINI_PADDED_SLAB_ITEM = ITEMS.register("mini_padded_slab", () -> new BlockItem(MINI_PADDED_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> MINI_PADDED_VERTICAL_SLAB = conditionallyRegisterBlock("mini_padded_vertical_slab", () -> new PaddedVerticalSlab(BlockBehaviour.Properties.copy(PADDED_BLOCK.get())), () -> isLoaded("quark"));
    public static final RegistryObject<Item> MINI_PADDED_VERTICAL_SLAB_ITEM = conditionallyRegisterItem("mini_padded_vertical_slab", () -> new BlockItem(MINI_PADDED_VERTICAL_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), () -> isLoaded("quark"));

    public static final RegistryObject<Block> MINI_PADDED_STAIRS = BLOCKS.register("mini_padded_stairs", () -> new PaddedStairs(BlockBehaviour.Properties.copy(PADDED_BLOCK.get())));
    public static final RegistryObject<Item> MINI_PADDED_STAIRS_ITEM = ITEMS.register("mini_padded_stairs", () -> new BlockItem(MINI_PADDED_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> PADDED_TRAPDOOR = BLOCKS.register("padded_trapdoor", () -> new DustrialTrapDoor(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.WOOL)));
    public static final RegistryObject<Item> PADDED_TRAPDOOR_ITEM = ITEMS.register("padded_trapdoor", () -> new BlockItem(PADDED_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<Block> PADDED_DOOR = BLOCKS.register("padded_door", () -> new DustrialDoor(BlockBehaviour.Properties.copy(PADDED_TRAPDOOR.get())));
    public static final RegistryObject<Item> PADDED_DOOR_ITEM = ITEMS.register("padded_door", () -> new BlockItem(PADDED_DOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<Block> CHAIN_LINK_FENCE = BLOCKS.register("chain_link_fence", () -> new DustrialPane(BlockBehaviour.Properties.copy(Blocks.IRON_BARS).sound(SoundType.CHAIN), true, false));
    public static final RegistryObject<Item> CHAIN_LINK_FENCE_ITEM = ITEMS.register("chain_link_fence", () -> new BlockItem(CHAIN_LINK_FENCE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> BARBED_CHAIN_LINK_FENCE = BLOCKS.register("barbed_chain_link_fence", () -> new DustrialPane(BlockBehaviour.Properties.copy(Blocks.IRON_BARS).sound(SoundType.CHAIN), true, true));
    public static final RegistryObject<Item> BARBED_CHAIN_LINK_FENCE_ITEM = ITEMS.register("barbed_chain_link_fence", () -> new BlockItem(BARBED_CHAIN_LINK_FENCE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> BARBED_IRON_BARS = BLOCKS.register("barbed_iron_bars", () -> new DustrialPane(BlockBehaviour.Properties.copy(Blocks.IRON_BARS).sound(SoundType.METAL), false, true));
    public static final RegistryObject<Item> BARBED_IRON_BARS_ITEM = ITEMS.register("barbed_iron_bars", () -> new BlockItem(BARBED_IRON_BARS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> GOLD_CHAIN = BLOCKS.register("gold_chain", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));
    public static final RegistryObject<Item> GOLD_CHAIN_ITEM = ITEMS.register("gold_chain", () -> new BlockItem(GOLD_CHAIN.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Block> LARGE_CHAIN = BLOCKS.register("large_chain", () -> new LargeChain(BlockBehaviour.Properties.copy(Blocks.CHAIN)));
    public static final RegistryObject<Item> LARGE_CHAIN_ITEM = ITEMS.register("large_chain", () -> new BlockItem(LARGE_CHAIN.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Block> LARGE_GOLD_CHAIN = BLOCKS.register("large_gold_chain", () -> new LargeChain(BlockBehaviour.Properties.copy(Blocks.CHAIN)));
    public static final RegistryObject<Item> LARGE_GOLD_CHAIN_ITEM = ITEMS.register("large_gold_chain", () -> new BlockItem(LARGE_GOLD_CHAIN.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Block> LARGE_ICE_CHAIN = conditionallyRegisterBlock("large_ice_chain", () -> new LargeChain(BlockBehaviour.Properties.copy(Blocks.CHAIN)), () -> isLoaded("environmental"));
    public static final RegistryObject<Item> LARGE_ICE_CHAIN_ITEM = conditionallyRegisterItem("large_ice_chain", () -> new BlockItem(LARGE_ICE_CHAIN.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)), () -> isLoaded("environmental"));


    public static final RegistryObject<Block> ANCHOR = BLOCKS.register("anchor", () -> new DoubleBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));
    public static final RegistryObject<Item> ANCHOR_ITEM = ITEMS.register("anchor", () -> new BlockItem(ANCHOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Block> HOOK = BLOCKS.register("hook", () -> new HookBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));
    public static final RegistryObject<Item> HOOK_ITEM = ITEMS.register("hook", () -> new BlockItem(HOOK.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));


    public static final RegistryObject<Block> CHAIN_TRAPDOOR = BLOCKS.register("chain_trapdoor", () -> new DustrialTrapDoor(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 1F).sound(SoundType.CHAIN)));
    public static final RegistryObject<Item> CHAIN_TRAPDOOR_ITEM = ITEMS.register("chain_trapdoor", () -> new BlockItem(CHAIN_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<Block> CHAIN_DOOR = BLOCKS.register("chain_door", () -> new DustrialDoor(BlockBehaviour.Properties.copy(CHAIN_TRAPDOOR.get())));
    public static final RegistryObject<Item> CHAIN_DOOR_ITEM = ITEMS.register("chain_door", () -> new BlockItem(CHAIN_DOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<Item> INDUSTRIAL_IRON_BILLET = ITEMS.register("industrial_iron_billet", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<Block> INDUSTRIAL_IRON_BLOCK = BLOCKS.register("industrial_iron_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Item> INDUSTRIAL_IRON_BLOCK_ITEM = ITEMS.register("industrial_iron_block", () -> new BlockItem(INDUSTRIAL_IRON_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> INDUSTRIAL_IRON_PILLAR = BLOCKS.register("industrial_iron_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Item> INDUSTRIAL_IRON_PILLAR_ITEM = ITEMS.register("industrial_iron_pillar", () -> new BlockItem(INDUSTRIAL_IRON_PILLAR.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> BOLTED_INDUSTRIAL_IRON_BLOCK = BLOCKS.register("bolted_industrial_iron_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Item> BOLTED_INDUSTRIAL_IRON_BLOCK_ITEM = ITEMS.register("bolted_industrial_iron_block", () -> new BlockItem(BOLTED_INDUSTRIAL_IRON_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> BOLTED_INDUSTRIAL_IRON_SLAB = BLOCKS.register("bolted_industrial_iron_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(BOLTED_INDUSTRIAL_IRON_BLOCK.get()).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Item> BOLTED_INDUSTRIAL_IRON_SLAB_ITEM = ITEMS.register("bolted_industrial_iron_slab", () -> new BlockItem(BOLTED_INDUSTRIAL_IRON_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> BOLTED_INDUSTRIAL_IRON_VERTICAL_SLAB = conditionallyRegisterBlock("bolted_industrial_iron_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(BOLTED_INDUSTRIAL_IRON_BLOCK.get())), () -> isLoaded("quark"));
    public static final RegistryObject<Item> BOLTED_INDUSTRIAL_IRON_VERTICAL_SLAB_ITEM = conditionallyRegisterItem("bolted_industrial_iron_vertical_slab", () -> new BlockItem(BOLTED_INDUSTRIAL_IRON_VERTICAL_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), () -> isLoaded("quark"));


    public static final RegistryObject<Block> BOLTED_INDUSTRIAL_IRON_STAIRS = BLOCKS.register("bolted_industrial_iron_stairs", () -> new StairBlock(() -> BOLTED_INDUSTRIAL_IRON_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(BOLTED_INDUSTRIAL_IRON_BLOCK.get()).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Item> BOLTED_INDUSTRIAL_IRON_STAIRS_ITEM = ITEMS.register("bolted_industrial_iron_stairs", () -> new BlockItem(BOLTED_INDUSTRIAL_IRON_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> INDUSTRIAL_IRON_TRAPDOOR = BLOCKS.register("industrial_iron_trapdoor", () -> new DustrialTrapDoor(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Item> INDUSTRIAL_IRON_TRAPDOOR_ITEM = ITEMS.register("industrial_iron_trapdoor", () -> new BlockItem(INDUSTRIAL_IRON_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<Block> INDUSTRIAL_IRON_DOOR = BLOCKS.register("industrial_iron_door", () -> new DustrialDoor(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Item> INDUSTRIAL_IRON_DOOR_ITEM = ITEMS.register("industrial_iron_door", () -> new BlockItem(INDUSTRIAL_IRON_DOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<Item> CAST_IRON_BILLET = ITEMS.register("cast_iron_billet", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<Block> CAST_IRON_BLOCK = BLOCKS.register("cast_iron_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Item> CAST_IRON_BLOCK_ITEM = ITEMS.register("cast_iron_block", () -> new BlockItem(CAST_IRON_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CAST_IRON_PILLAR = BLOCKS.register("cast_iron_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Item> CAST_IRON_PILLAR_ITEM = ITEMS.register("cast_iron_pillar", () -> new BlockItem(CAST_IRON_PILLAR.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CAST_IRON_BRICKS = BLOCKS.register("cast_iron_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Item> CAST_IRON_BRICKS_ITEM = ITEMS.register("cast_iron_bricks", () -> new BlockItem(CAST_IRON_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CAST_IRON_BRICKS_SLAB = BLOCKS.register("cast_iron_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CAST_IRON_BRICKS.get()).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Item> CAST_IRON_BRICKS_SLAB_ITEM = ITEMS.register("cast_iron_brick_slab", () -> new BlockItem(CAST_IRON_BRICKS_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CAST_IRON_BRICKS_VERTICAL_SLAB = conditionallyRegisterBlock("cast_iron_brick_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(CAST_IRON_BRICKS.get())), () -> isLoaded("quark"));
    public static final RegistryObject<Item> CAST_IRON_BRICKS_VERTICAL_SLAB_ITEM = conditionallyRegisterItem("cast_iron_brick_vertical_slab", () -> new BlockItem(CAST_IRON_BRICKS_VERTICAL_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), () -> isLoaded("quark"));


    public static final RegistryObject<Block> CAST_IRON_BRICKS_STAIRS = BLOCKS.register("cast_iron_brick_stairs", () -> new StairBlock(() -> CAST_IRON_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CAST_IRON_BRICKS.get()).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Item> CAST_IRON_BRICKS_STAIRS_ITEM = ITEMS.register("cast_iron_brick_stairs", () -> new BlockItem(CAST_IRON_BRICKS_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));


    public static final RegistryObject<Block> ENGRAVED_CAST_IRON_BLOCK = BLOCKS.register("engraved_cast_iron_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Item> ENGRAVED_CAST_IRON_BLOCK_ITEM = ITEMS.register("engraved_cast_iron_block", () -> new BlockItem(ENGRAVED_CAST_IRON_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CAST_IRON_BALUSTRADE = BLOCKS.register("cast_iron_balustrade", () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistryObject<Item> CAST_IRON_BALUSTRADE_ITEM = ITEMS.register("cast_iron_balustrade", () -> new BlockItem(CAST_IRON_BALUSTRADE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

//    public static final RegistryObject<Block> CAST_IRON_FACADE = BLOCKS.register("cast_iron_facade", () -> new PaneBlock(Block.Properties.from(Blocks.IRON_BLOCK).sound(SoundType.NETHERITE)));
//    public static final RegistryObject<Item> CAST_IRON_FACADE_ITEM = ITEMS.register("cast_iron_facade", () -> new BlockItem(CAST_IRON_FACADE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));


    public static final RegistryObject<Item> SHEET_METAL = ITEMS.register("sheet_metal", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<Block> SHEET_METAL_PLATING = BLOCKS.register("sheet_metal_plating", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 3.5F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> SHEET_METAL_PLATING_ITEM = ITEMS.register("sheet_metal_plating", () -> new BlockItem(SHEET_METAL_PLATING.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_PLATING_SLAB = BLOCKS.register("sheet_metal_plating_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SHEET_METAL_PLATING.get())));
    public static final RegistryObject<Item> SHEET_METAL_PLATING_SLAB_ITEM = ITEMS.register("sheet_metal_plating_slab", () -> new BlockItem(SHEET_METAL_PLATING_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_PLATING_VERTICAL_SLAB = conditionallyRegisterBlock("sheet_metal_plating_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(SHEET_METAL_PLATING.get())), () -> isLoaded("quark"));
    public static final RegistryObject<Item> SHEET_METAL_PLATING_VERTICAL_SLAB_ITEM = conditionallyRegisterItem("sheet_metal_plating_vertical_slab", () -> new BlockItem(SHEET_METAL_PLATING_VERTICAL_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), () -> isLoaded("quark"));


    public static final RegistryObject<Block> SHEET_METAL_PLATING_STAIRS = BLOCKS.register("sheet_metal_plating_stairs", () -> new StairBlock(() -> SHEET_METAL_PLATING.get().defaultBlockState(), BlockBehaviour.Properties.copy(SHEET_METAL_PLATING.get())));
    public static final RegistryObject<Item> SHEET_METAL_PLATING_STAIRS_ITEM = ITEMS.register("sheet_metal_plating_stairs", () -> new BlockItem(SHEET_METAL_PLATING_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_PANELING = BLOCKS.register("sheet_metal_paneling", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 3.5F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> SHEET_METAL_PANELING_ITEM = ITEMS.register("sheet_metal_paneling", () -> new BlockItem(SHEET_METAL_PANELING.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_SIDING = BLOCKS.register("sheet_metal_siding", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 3.5F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> SHEET_METAL_SIDING_ITEM = ITEMS.register("sheet_metal_siding", () -> new BlockItem(SHEET_METAL_SIDING.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_WALLING = BLOCKS.register("sheet_metal_walling", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 3.5F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> SHEET_METAL_WALLING_ITEM = ITEMS.register("sheet_metal_walling", () -> new BlockItem(SHEET_METAL_WALLING.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_TREADING = BLOCKS.register("sheet_metal_treading", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 3.5F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> SHEET_METAL_TREADING_ITEM = ITEMS.register("sheet_metal_treading", () -> new BlockItem(SHEET_METAL_TREADING.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_TREADING_SLAB = BLOCKS.register("sheet_metal_treading_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SHEET_METAL_TREADING.get())));
    public static final RegistryObject<Item> SHEET_METAL_TREADING_SLAB_ITEM = ITEMS.register("sheet_metal_treading_slab", () -> new BlockItem(SHEET_METAL_TREADING_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_TREADING_VERTICAL_SLAB = conditionallyRegisterBlock("sheet_metal_treading_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(SHEET_METAL_TREADING.get())), () -> isLoaded("quark"));
    public static final RegistryObject<Item> SHEET_METAL_TREADING_VERTICAL_SLAB_ITEM = conditionallyRegisterItem("sheet_metal_treading_vertical_slab", () -> new BlockItem(SHEET_METAL_TREADING_VERTICAL_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), () -> isLoaded("quark"));

    public static final RegistryObject<Block> SHEET_METAL_TREADING_STAIRS = BLOCKS.register("sheet_metal_treading_stairs", () -> new StairBlock(() -> SHEET_METAL_TREADING.get().defaultBlockState(), BlockBehaviour.Properties.copy(SHEET_METAL_TREADING.get())));
    public static final RegistryObject<Item> SHEET_METAL_TREADING_STAIRS_ITEM = ITEMS.register("sheet_metal_treading_stairs", () -> new BlockItem(SHEET_METAL_TREADING_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SHEET_METAL_TRAPDOOR = BLOCKS.register("sheet_metal_trapdoor", () -> new DustrialTrapDoor(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 1F).sound(SoundType.METAL)));
    public static final RegistryObject<Item> SHEET_METAL_TRAPDOOR_ITEM = ITEMS.register("sheet_metal_trapdoor", () -> new BlockItem(SHEET_METAL_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<Block> SHEET_METAL_DOOR = BLOCKS.register("sheet_metal_door", () -> new DustrialDoor(BlockBehaviour.Properties.copy(SHEET_METAL_TRAPDOOR.get())));
    public static final RegistryObject<Item> SHEET_METAL_DOOR_ITEM = ITEMS.register("sheet_metal_door", () -> new BlockItem(SHEET_METAL_DOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<Item> RUSTY_SHEET_METAL = ITEMS.register("rusty_sheet_metal", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_PLATING = BLOCKS.register("rusty_sheet_metal_plating", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 3.5F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_PLATING_ITEM = ITEMS.register("rusty_sheet_metal_plating", () -> new BlockItem(RUSTY_SHEET_METAL_PLATING.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_PLATING_SLAB = BLOCKS.register("rusty_sheet_metal_plating_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(RUSTY_SHEET_METAL_PLATING.get())));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_PLATING_SLAB_ITEM = ITEMS.register("rusty_sheet_metal_plating_slab", () -> new BlockItem(RUSTY_SHEET_METAL_PLATING_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_PLATING_VERTICAL_SLAB = conditionallyRegisterBlock("rusty_sheet_metal_plating_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(RUSTY_SHEET_METAL_PLATING.get())), () -> isLoaded("quark"));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_PLATING_VERTICAL_SLAB_ITEM = conditionallyRegisterItem("rusty_sheet_metal_plating_vertical_slab", () -> new BlockItem(RUSTY_SHEET_METAL_PLATING_VERTICAL_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), () -> isLoaded("quark"));


    public static final RegistryObject<Block> RUSTY_SHEET_METAL_PLATING_STAIRS = BLOCKS.register("rusty_sheet_metal_plating_stairs", () -> new StairBlock(() -> RUSTY_SHEET_METAL_PLATING.get().defaultBlockState(), BlockBehaviour.Properties.copy(RUSTY_SHEET_METAL_PLATING.get())));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_PLATING_STAIRS_ITEM = ITEMS.register("rusty_sheet_metal_plating_stairs", () -> new BlockItem(RUSTY_SHEET_METAL_PLATING_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_PANELING = BLOCKS.register("rusty_sheet_metal_paneling", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 3.5F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_PANELING_ITEM = ITEMS.register("rusty_sheet_metal_paneling", () -> new BlockItem(RUSTY_SHEET_METAL_PANELING.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_SIDING = BLOCKS.register("rusty_sheet_metal_siding", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 3.5F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_SIDING_ITEM = ITEMS.register("rusty_sheet_metal_siding", () -> new BlockItem(RUSTY_SHEET_METAL_SIDING.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_WALLING = BLOCKS.register("rusty_sheet_metal_walling", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 3.5F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_WALLING_ITEM = ITEMS.register("rusty_sheet_metal_walling", () -> new BlockItem(RUSTY_SHEET_METAL_WALLING.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_TREADING = BLOCKS.register("rusty_sheet_metal_treading", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).strength(3.0F, 3.5F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_TREADING_ITEM = ITEMS.register("rusty_sheet_metal_treading", () -> new BlockItem(RUSTY_SHEET_METAL_TREADING.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_TREADING_SLAB = BLOCKS.register("rusty_sheet_metal_treading_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(RUSTY_SHEET_METAL_TREADING.get())));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_TREADING_SLAB_ITEM = ITEMS.register("rusty_sheet_metal_treading_slab", () -> new BlockItem(RUSTY_SHEET_METAL_TREADING_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_TREADING_VERTICAL_SLAB = conditionallyRegisterBlock("rusty_sheet_metal_treading_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(RUSTY_SHEET_METAL_TREADING.get())), () -> isLoaded("quark"));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_TREADING_VERTICAL_SLAB_ITEM = conditionallyRegisterItem("rusty_sheet_metal_treading_vertical_slab", () -> new BlockItem(RUSTY_SHEET_METAL_TREADING_VERTICAL_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), () -> isLoaded("quark"));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_TREADING_STAIRS = BLOCKS.register("rusty_sheet_metal_treading_stairs", () -> new StairBlock(() -> RUSTY_SHEET_METAL_TREADING.get().defaultBlockState(), BlockBehaviour.Properties.copy(RUSTY_SHEET_METAL_TREADING.get())));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_TREADING_STAIRS_ITEM = ITEMS.register("rusty_sheet_metal_treading_stairs", () -> new BlockItem(RUSTY_SHEET_METAL_TREADING_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_TRAPDOOR = BLOCKS.register("rusty_sheet_metal_trapdoor", () -> new DustrialTrapDoor(BlockBehaviour.Properties.of(Material.STONE).strength(1F, 1F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_TRAPDOOR_ITEM = ITEMS.register("rusty_sheet_metal_trapdoor", () -> new BlockItem(RUSTY_SHEET_METAL_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<Block> RUSTY_SHEET_METAL_DOOR = BLOCKS.register("rusty_sheet_metal_door", () -> new DustrialDoor(BlockBehaviour.Properties.copy(RUSTY_SHEET_METAL_TRAPDOOR.get())));
    public static final RegistryObject<Item> RUSTY_SHEET_METAL_DOOR_ITEM = ITEMS.register("rusty_sheet_metal_door", () -> new BlockItem(RUSTY_SHEET_METAL_DOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<Block> CINDER_BLOCK = BLOCKS.register("cinder_block", () -> new CinderBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Item> CINDER_BLOCK_ITEM = ITEMS.register("cinder_block", () -> new BlockItem(CINDER_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> POLISHED_CINDER_BLOCK = BLOCKS.register("polished_cinder_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Item> POLISHED_CINDER_BLOCK_ITEM = ITEMS.register("polished_cinder_block", () -> new BlockItem(POLISHED_CINDER_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CINDER_BRICKS = BLOCKS.register("cinder_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Item> CINDER_BRICKS_ITEM = ITEMS.register("cinder_bricks", () -> new BlockItem(CINDER_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CINDER_BRICKS_SLAB = BLOCKS.register("cinder_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CINDER_BRICKS.get())));
    public static final RegistryObject<Item> CINDER_BRICKS_SLAB_ITEM = ITEMS.register("cinder_brick_slab", () -> new BlockItem(CINDER_BRICKS_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CINDER_BRICKS_VERTICAL_SLAB = conditionallyRegisterBlock("cinder_brick_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(CINDER_BRICKS.get())), () -> isLoaded("quark"));
    public static final RegistryObject<Item> CINDER_BRICKS_VERTICAL_SLAB_ITEM = conditionallyRegisterItem("cinder_brick_vertical_slab", () -> new BlockItem(CINDER_BRICKS_VERTICAL_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), () -> isLoaded("quark"));


    public static final RegistryObject<Block> CINDER_BRICKS_STAIRS = BLOCKS.register("cinder_brick_stairs", () -> new StairBlock(() -> CINDER_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CINDER_BRICKS.get())));
    public static final RegistryObject<Item> CINDER_BRICKS_STAIRS_ITEM = ITEMS.register("cinder_brick_stairs", () -> new BlockItem(CINDER_BRICKS_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Item> CARDBOARD = ITEMS.register("cardboard", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<Block> CARDBOARD_BOX = BLOCKS.register("cardboard_box", () -> new DirectionalBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.WOOD).strength(1.0F, 0.3F).sound(CARDBOARD_SOUND)));
    public static final RegistryObject<Item> CARDBOARD_BOX_ITEM = ITEMS.register("cardboard_box", () -> new BlockItem(CARDBOARD_BOX.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SMOOTH_CARDBOARD = BLOCKS.register("smooth_cardboard", () -> new CardboardBlock(BlockBehaviour.Properties.copy(CARDBOARD_BOX.get())));
    public static final RegistryObject<Item> SMOOTH_CARDBOARD_ITEM = ITEMS.register("smooth_cardboard", () -> new BlockItem(SMOOTH_CARDBOARD.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SMOOTH_CARDBOARD_SLAB = BLOCKS.register("smooth_cardboard_slab", () -> new CardboardSlab(BlockBehaviour.Properties.copy(SMOOTH_CARDBOARD.get())));
    public static final RegistryObject<Item> SMOOTH_CARDBOARD_SLAB_ITEM = ITEMS.register("smooth_cardboard_slab", () -> new BlockItem(SMOOTH_CARDBOARD_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> SMOOTH_CARDBOARD_VERTICAL_SLAB = conditionallyRegisterBlock("smooth_cardboard_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(SMOOTH_CARDBOARD.get())), () -> isLoaded("quark"));
    public static final RegistryObject<Item> SMOOTH_CARDBOARD_VERTICAL_SLAB_ITEM = conditionallyRegisterItem("smooth_cardboard_vertical_slab", () -> new BlockItem(SMOOTH_CARDBOARD_VERTICAL_SLAB.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), () -> isLoaded("quark"));


    public static final RegistryObject<Block> SMOOTH_CARDBOARD_STAIRS = BLOCKS.register("smooth_cardboard_stairs", () -> new CardboardStairs(BlockBehaviour.Properties.copy(SMOOTH_CARDBOARD.get())));
    public static final RegistryObject<Item> SMOOTH_CARDBOARD_STAIRS_ITEM = ITEMS.register("smooth_cardboard_stairs", () -> new BlockItem(SMOOTH_CARDBOARD_STAIRS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> FOLDED_CARDBOARD = BLOCKS.register("folded_cardboard", () -> new CardboardBlock(BlockBehaviour.Properties.copy(CARDBOARD_BOX.get())));
    public static final RegistryObject<Item> FOLDED_CARDBOARD_ITEM = ITEMS.register("folded_cardboard", () -> new BlockItem(FOLDED_CARDBOARD.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CARDBOARD_SCRAP = BLOCKS.register("cardboard_scrap", () -> new CardboardBlock(BlockBehaviour.Properties.copy(CARDBOARD_BOX.get())));
    public static final RegistryObject<Item> CARDBOARD_SCRAP_ITEM = ITEMS.register("cardboard_scrap", () -> new BlockItem(CARDBOARD_SCRAP.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CARDBOARD_TRAPDOOR = BLOCKS.register("cardboard_trapdoor", () -> new DustrialTrapDoor(BlockBehaviour.Properties.copy(CARDBOARD_BOX.get())));
    public static final RegistryObject<Item> CARDBOARD_TRAPDOOR_ITEM = ITEMS.register("cardboard_trapdoor", () -> new BlockItem(CARDBOARD_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<Block> CARDBOARD_DOOR = BLOCKS.register("cardboard_door", () -> new DustrialDoor(BlockBehaviour.Properties.copy(CARDBOARD_TRAPDOOR.get())));
    public static final RegistryObject<Item> CARDBOARD_DOOR_ITEM = ITEMS.register("cardboard_door", () -> new BlockItem(CARDBOARD_DOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<Item> CARDBOARD_HELMET = ITEMS.register("cardboard_helmet", () -> new CardboardArmor(CARDBOARD_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> CARDBOARD_CHESTPLATE = ITEMS.register("cardboard_chestplate", () -> new CardboardArmor(CARDBOARD_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> CARDBOARD_LEGGINGS = ITEMS.register("cardboard_leggings", () -> new CardboardArmor(CARDBOARD_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> CARDBOARD_BOOTS = ITEMS.register("cardboard_boots", () -> new CardboardArmor(CARDBOARD_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> RUSTY_IRON_INGOT = ITEMS.register("rusty_iron_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> RUSTY_IRON_NUGGET = ITEMS.register("rusty_iron_nugget", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

    public static final RegistryObject<Block> RUSTY_IRON_BLOCK = BLOCKS.register("rusty_iron_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Item> RUSTY_IRON_BLOCK_ITEM = ITEMS.register("rusty_iron_block", () -> new BlockItem(RUSTY_IRON_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RUSTY_IRON_TRAPDOOR = BLOCKS.register("rusty_iron_trapdoor", () -> new DustrialTrapDoor(BlockBehaviour.Properties.copy(Blocks.IRON_DOOR)));
    public static final RegistryObject<Item> RUSTY_IRON_TRAPDOOR_ITEM = ITEMS.register("rusty_iron_trapdoor", () -> new BlockItem(RUSTY_IRON_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<Block> RUSTY_IRON_DOOR = BLOCKS.register("rusty_iron_door", () -> new DustrialDoor(BlockBehaviour.Properties.copy(RUSTY_IRON_TRAPDOOR.get())));
    public static final RegistryObject<Item> RUSTY_IRON_DOOR_ITEM = ITEMS.register("rusty_iron_door", () -> new BlockItem(RUSTY_IRON_DOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<Block> WRAPPED_CHAINS = BLOCKS.register("wrapped_chains", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));
    public static final RegistryObject<Item> WRAPPED_CHAINS_ITEM = ITEMS.register("wrapped_chains", () -> new BlockItem(WRAPPED_CHAINS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> WRAPPED_GOLD_CHAINS = BLOCKS.register("wrapped_gold_chains", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));
    public static final RegistryObject<Item> WRAPPED_GOLD_CHAINS_ITEM = ITEMS.register("wrapped_gold_chains", () -> new BlockItem(WRAPPED_GOLD_CHAINS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> WRAPPED_ICE_CHAINS = conditionallyRegisterBlock("wrapped_ice_chains", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)), () -> isLoaded("environmental"));
    public static final RegistryObject<Item> WRAPPED_ICE_CHAINS_ITEM = conditionallyRegisterItem("wrapped_ice_chains", () -> new BlockItem(WRAPPED_ICE_CHAINS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)), () -> isLoaded("environmental"));

    public static final RegistryObject<Block> IRON_BAR_TRAPDOOR = BLOCKS.register("iron_bar_trapdoor", () -> new DustrialTrapDoor(BlockBehaviour.Properties.copy(Blocks.IRON_BARS).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> IRON_BAR_TRAPDOOR_ITEM = ITEMS.register("iron_bar_trapdoor", () -> new BlockItem(IRON_BAR_TRAPDOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<Block> IRON_BAR_DOOR = BLOCKS.register("iron_bar_door", () -> new DustrialDoor(BlockBehaviour.Properties.copy(IRON_BAR_TRAPDOOR.get())));
    public static final RegistryObject<Item> IRON_BAR_DOOR_ITEM = ITEMS.register("iron_bar_door", () -> new BlockItem(IRON_BAR_DOOR.get(), new Item.Properties().tab(CreativeModeTab.TAB_REDSTONE)));

    public static final RegistryObject<Block> REDSTONE_LANTERN = BLOCKS.register("redstone_lantern", () -> new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN).lightLevel(blockState -> 7)));
    public static final RegistryObject<Item> REDSTONE_LANTERN_ITEM = ITEMS.register("redstone_lantern", () -> new BlockItem(REDSTONE_LANTERN.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));


    public static final RegistryObject<Block> LARGE_LANTERN = BLOCKS.register("large_lantern", () -> new Block(BlockBehaviour.Properties.copy(Blocks.LANTERN).lightLevel(blockState -> 15)));
    public static final RegistryObject<Item> LARGE_LANTERN_ITEM = ITEMS.register("large_lantern", () -> new BlockItem(LARGE_LANTERN.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Block> LARGE_SOUL_LANTERN = BLOCKS.register("large_soul_lantern", () -> new Block(BlockBehaviour.Properties.copy(Blocks.LANTERN).lightLevel(blockState -> 15)));
    public static final RegistryObject<Item> LARGE_SOUL_LANTERN_ITEM = ITEMS.register("large_soul_lantern", () -> new BlockItem(LARGE_SOUL_LANTERN.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static final RegistryObject<Block> LARGE_REDSTONE_LANTERN = BLOCKS.register("large_redstone_lantern", () -> new RedstoneLampBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN).lightLevel(getLightValueLit(12))));
    public static final RegistryObject<Item> LARGE_REDSTONE_LANTERN_ITEM = ITEMS.register("large_redstone_lantern", () -> new BlockItem(LARGE_REDSTONE_LANTERN.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));


    public static final RegistryObject<Block> LARGE_ENDER_LANTERN = conditionallyRegisterBlock("large_ender_lantern", () -> new Block(BlockBehaviour.Properties.copy(Blocks.LANTERN).lightLevel(blockState -> 15)), () -> isLoaded("endergetic"));
    public static final RegistryObject<Item> LARGE_ENDER_LANTERN_ITEM = conditionallyRegisterItem("large_ender_lantern", () -> new BlockItem(LARGE_ENDER_LANTERN.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)), () -> isLoaded("endergetic"));

    public static final RegistryObject<Block> LARGE_CURSED_LANTERN = conditionallyRegisterBlock("large_cursed_lantern", () -> new Block(BlockBehaviour.Properties.copy(Blocks.LANTERN).lightLevel(blockState -> 15)), () -> isLoaded("caverns_and_chasms"));
    public static final RegistryObject<Item> LARGE_CURSED_LANTERN_ITEM = conditionallyRegisterItem("large_cursed_lantern", () -> new BlockItem(LARGE_CURSED_LANTERN.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)), () -> isLoaded("caverns_and_chasms"));

    public static final RegistryObject<Block> LARGE_GLOW_LANTERN = conditionallyRegisterBlock("large_glow_lantern", () -> new Block(BlockBehaviour.Properties.copy(Blocks.LANTERN).lightLevel(blockState -> 15)), () -> isLoaded("infernalexp"));
    public static final RegistryObject<Item> LARGE_GLOW_LANTERN_ITEM = conditionallyRegisterItem("large_glow_lantern", () -> new BlockItem(LARGE_GLOW_LANTERN.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)), () -> isLoaded("infernalexp"));


    public static final RegistryObject<Block> RED_NEON_LIGHT = BLOCKS.register("red_neon_light", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).lightLevel(blockState -> 15)));
    public static final RegistryObject<Item> RED_NEON_LIGHT_ITEM = ITEMS.register("red_neon_light", () -> new BlockItem(RED_NEON_LIGHT.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> ORANGE_NEON_LIGHT = BLOCKS.register("orange_neon_light", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).lightLevel(blockState -> 15)));
    public static final RegistryObject<Item> ORANGE_NEON_LIGHT_ITEM = ITEMS.register("orange_neon_light", () -> new BlockItem(ORANGE_NEON_LIGHT.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> YELLOW_NEON_LIGHT = BLOCKS.register("yellow_neon_light", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).lightLevel(blockState -> 15)));
    public static final RegistryObject<Item> YELLOW_NEON_LIGHT_ITEM = ITEMS.register("yellow_neon_light", () -> new BlockItem(YELLOW_NEON_LIGHT.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> GREEN_NEON_LIGHT = BLOCKS.register("green_neon_light", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).lightLevel(blockState -> 15)));
    public static final RegistryObject<Item> GREEN_NEON_LIGHT_ITEM = ITEMS.register("green_neon_light", () -> new BlockItem(GREEN_NEON_LIGHT.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> CYAN_NEON_LIGHT = BLOCKS.register("cyan_neon_light", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).lightLevel(blockState -> 15)));
    public static final RegistryObject<Item> CYAN_NEON_LIGHT_ITEM = ITEMS.register("cyan_neon_light", () -> new BlockItem(CYAN_NEON_LIGHT.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> BLUE_NEON_LIGHT = BLOCKS.register("blue_neon_light", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).lightLevel(blockState -> 15)));
    public static final RegistryObject<Item> BLUE_NEON_LIGHT_ITEM = ITEMS.register("blue_neon_light", () -> new BlockItem(BLUE_NEON_LIGHT.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> PINK_NEON_LIGHT = BLOCKS.register("pink_neon_light", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).lightLevel(blockState -> 15)));
    public static final RegistryObject<Item> PINK_NEON_LIGHT_ITEM = ITEMS.register("pink_neon_light", () -> new BlockItem(PINK_NEON_LIGHT.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> PURPLE_NEON_LIGHT = BLOCKS.register("purple_neon_light", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).lightLevel(blockState -> 15)));
    public static final RegistryObject<Item> PURPLE_NEON_LIGHT_ITEM = ITEMS.register("purple_neon_light", () -> new BlockItem(PURPLE_NEON_LIGHT.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> RAINBOW_NEON_LIGHT = BLOCKS.register("rainbow_neon_light", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).lightLevel(blockState -> 15)));
    public static final RegistryObject<Item> RAINBOW_NEON_LIGHT_ITEM = ITEMS.register("rainbow_neon_light", () -> new BlockItem(RAINBOW_NEON_LIGHT.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<Block> BLACK_LIGHT = BLOCKS.register("black_light", () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLOWSTONE).lightLevel(blockState -> 7)));
    public static final RegistryObject<Item> BLACK_LIGHT_ITEM = ITEMS.register("black_light", () -> new BlockItem(BLACK_LIGHT.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));



    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    public static RegistryObject<Item> conditionallyRegisterItem(String registryName, Supplier<Item> item, Supplier<Boolean> condition) {
        if (condition.get())
            return ITEMS.register(registryName, item);
        return null;
    }
    public static RegistryObject<Block> conditionallyRegisterBlock(String registryName, Supplier<Block> block, Supplier<Boolean> condition) {
        if (condition.get())
            return BLOCKS.register(registryName, block);
        return null;
    }

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> {
            return state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
        };
    }

    public static boolean isLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }

}
