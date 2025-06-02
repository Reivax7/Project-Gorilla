package com.reivax.projgorilla.entity;

import com.reivax.projgorilla.ProjectGorilla;
import com.reivax.projgorilla.entity.custom.GorillaEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ProjectGorilla.MOD_ID);

    public static final RegistryObject<EntityType<GorillaEntity>> GORILLA =
            ENTITY_TYPES.register("gorilla", () -> EntityType.Builder.of(GorillaEntity::new, MobCategory.CREATURE)
                    .sized(1.2f,2.0f).build("gorilla"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
