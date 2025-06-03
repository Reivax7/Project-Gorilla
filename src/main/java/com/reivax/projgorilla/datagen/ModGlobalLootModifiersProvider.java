package com.reivax.projgorilla.datagen;

import com.reivax.projgorilla.ProjectGorilla;
import com.reivax.projgorilla.item.ModItems;
import com.reivax.projgorilla.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, ProjectGorilla.MOD_ID);
    }

    @Override
    protected void start() {
        add("banana_from_jungle_leaves", new AddItemModifier(new LootItemCondition[] {
                LootTableIdCondition.builder(new ResourceLocation("minecraft", "blocks/jungle_leaves")).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build()
        }, ModItems.BANANA.get()));
    }

    @Override
    public String getName() {
        return "ProjectGorilla Global Loot Modifiers";
    }




}
