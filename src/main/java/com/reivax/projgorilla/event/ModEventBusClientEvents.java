package com.reivax.projgorilla.event;

import com.reivax.projgorilla.ProjectGorilla;
import com.reivax.projgorilla.entity.client.GorillaModel;
import com.reivax.projgorilla.entity.client.ModModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ProjectGorilla.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(ModModelLayers.GORILLA_LAYER, GorillaModel::createBodyLayer);
        }

}
