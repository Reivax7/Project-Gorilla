package com.reivax.projgorilla.item;

import com.reivax.projgorilla.ProjectGorilla;
import com.reivax.projgorilla.entity.ModEntities;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ProjectGorilla.MOD_ID);

    public static final RegistryObject<Item> BANANA = ITEMS.register("banana", () -> new Item(new Item.Properties().food(ModFoods.BANANA)));

    public static final RegistryObject<Item> GORILLA_FUR = ITEMS.register("gorilla_fur", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GORILLA_SPAWN_EGG = ITEMS.register("gorilla_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.GORILLA, 0x343434, 0x36454F,
            new Item.Properties()));



    public static final RegistryObject<Item> GORILLA_FUR_HELMET = ITEMS.register("gorilla_fur_helmet",
            () -> new ArmorItem(ModArmorMaterials.GORILLA_FUR, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GORILLA_FUR_CHESTPLATE = ITEMS.register("gorilla_fur_chestplate",
            () -> new ArmorItem(ModArmorMaterials.GORILLA_FUR, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GORILLA_FUR_LEGGINGS = ITEMS.register("gorilla_fur_leggings",
            () -> new ArmorItem(ModArmorMaterials.GORILLA_FUR, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GORILLA_FUR_BOOTS = ITEMS.register("gorilla_fur_boots",
            () -> new ArmorItem(ModArmorMaterials.GORILLA_FUR, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
