package com.reivax.projgorilla.event;


import com.reivax.projgorilla.ProjectGorilla;
import com.reivax.projgorilla.entity.ModEntities;
import com.reivax.projgorilla.entity.custom.GorillaEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ProjectGorilla.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GORILLA.get(), GorillaEntity.createAttributes().build());
    }
}
