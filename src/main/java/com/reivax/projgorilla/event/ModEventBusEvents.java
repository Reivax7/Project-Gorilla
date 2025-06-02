package com.reivax.projgorilla.event;


import com.reivax.projgorilla.ProjectGorilla;
import com.reivax.projgorilla.entity.ModEntities;
import com.reivax.projgorilla.entity.custom.GorillaEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ProjectGorilla.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GORILLA.get(), GorillaEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event)  {
        event.register(ModEntities.GORILLA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, GorillaEntity::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.OR);
    }
}
