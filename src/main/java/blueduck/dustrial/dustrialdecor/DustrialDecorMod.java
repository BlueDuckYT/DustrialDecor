package blueduck.dustrial.dustrialdecor;

import blueduck.dustrial.dustrialdecor.registry.DustrialBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("dustrial_decor")
public class DustrialDecorMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static String MODID = "dustrial_decor";

    public DustrialDecorMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        DustrialBlocks.init();
    }

    private void setup(final FMLCommonSetupEvent event)
    {


        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }

    @Mod.EventBusSubscriber(modid = "dustrial_decor", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientEventBusSubscriber {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            RenderTypeLookup.setRenderLayer(DustrialBlocks.CHAIN_LINK_FENCE.get(), RenderType.getCutoutMipped());
            RenderTypeLookup.setRenderLayer(DustrialBlocks.BARBED_CHAIN_LINK_FENCE.get(), RenderType.getCutoutMipped());
            RenderTypeLookup.setRenderLayer(DustrialBlocks.BARBED_IRON_BARS.get(), RenderType.getCutoutMipped());
            RenderTypeLookup.setRenderLayer(DustrialBlocks.PADDED_TRAPDOOR.get(), RenderType.getCutoutMipped());
            RenderTypeLookup.setRenderLayer(DustrialBlocks.CHAIN_TRAPDOOR.get(), RenderType.getCutoutMipped());
            RenderTypeLookup.setRenderLayer(DustrialBlocks.PADDED_DOOR.get(), RenderType.getCutoutMipped());
            RenderTypeLookup.setRenderLayer(DustrialBlocks.CHAIN_DOOR.get(), RenderType.getCutoutMipped());
            RenderTypeLookup.setRenderLayer(DustrialBlocks.CARDBOARD_DOOR.get(), RenderType.getCutoutMipped());

        }
    }
    @Mod.EventBusSubscriber(modid = "dustrial_decor")
    public static class LootEvents {
        @SubscribeEvent
        public static void onLootLoad(LootTableLoadEvent event) {
            if (event.getName().equals(new ResourceLocation("minecraft", "chests/simple_dungeon"))) {
                event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(MODID, "chests/dungeon"))).build());
            }
            if (event.getName().equals(new ResourceLocation("minecraft", "chests/pillager_outpost"))) {
                event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(MODID, "chests/dungeon"))).build());
            }
            if (event.getName().equals(new ResourceLocation("minecraft", "chests/woodland_mansion"))) {
                event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(MODID, "chests/dungeon"))).build());
            }
            if (event.getName().equals(new ResourceLocation("minecraft", "chests/shipwreck_supply"))) {
                event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(MODID, "chests/dungeon"))).build());
            }
            if (event.getName().equals(new ResourceLocation("minecraft", "chests/stronghold_corridor"))) {
                event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(MODID, "chests/dungeon"))).build());
            }
            if (event.getName().equals(new ResourceLocation("minecraft", "chests/village/village_toolsmith"))) {
                event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(MODID, "chests/dungeon"))).build());
            }
            if (event.getName().equals(new ResourceLocation("minecraft", "chests/village/village_weaponsmith"))) {
                event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(MODID, "chests/dungeon"))).build());
            }
        }
    }
}
