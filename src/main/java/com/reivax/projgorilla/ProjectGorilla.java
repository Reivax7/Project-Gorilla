package com.reivax.projgorilla;

import com.mojang.logging.LogUtils;
import com.reivax.projgorilla.entity.ModEntities;
import com.reivax.projgorilla.entity.client.GorillaRenderer;
import com.reivax.projgorilla.item.ModItems;
import com.reivax.projgorilla.loot.ModLootModifiers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ProjectGorilla.MOD_ID)
public class ProjectGorilla {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "projgorilla";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public ProjectGorilla(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModItems.register(modEventBus);
        ModEntities.register(modEventBus);

        ModLootModifiers.register(modEventBus);



        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }



    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

           if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
            event.accept(ModItems.BANANA);

         if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS)
                event.accept(ModItems.GORILLA_SPAWN_EGG);

          if (event.getTabKey() == CreativeModeTabs.INGREDIENTS)
              event.accept(ModItems.GORILLA_FUR);

        if (event.getTabKey() == CreativeModeTabs.COMBAT)
            event.accept(ModItems.GORILLA_FUR_HELMET);

        if (event.getTabKey() == CreativeModeTabs.COMBAT)
            event.accept(ModItems.GORILLA_FUR_CHESTPLATE);

        if (event.getTabKey() == CreativeModeTabs.COMBAT)
            event.accept(ModItems.GORILLA_FUR_LEGGINGS);

        if (event.getTabKey() == CreativeModeTabs.COMBAT)
            event.accept(ModItems.GORILLA_FUR_BOOTS);




        }



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.GORILLA.get(), GorillaRenderer::new);

        }
    }
}
