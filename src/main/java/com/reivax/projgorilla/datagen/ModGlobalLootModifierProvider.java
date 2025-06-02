package com.reivax.projgorilla.datagen;

import com.reivax.projgorilla.ProjectGorilla;
import com.reivax.projgorilla.item.ModItems;
import com.reivax.projgorilla.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

    public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
        public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
            super(output, ProjectGorilla.MOD_ID);
        }

        protected void start(HolderLookup.Provider registries) {
            this.add("banana_from_jungle_leaves",
                    new AddItemModifier(new LootItemCondition[] {
                            LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.JUNGLE_LEAVES).build(),
                            LootItemRandomChanceCondition.randomChance(0.50f).build() }, ModItems.BANANA.get()));

        }

        @Override
        protected void start() {

        }
    }

