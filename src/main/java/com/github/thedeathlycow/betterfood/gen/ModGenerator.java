package com.github.thedeathlycow.betterfood.gen;

import com.github.thedeathlycow.betterfood.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class ModGenerator {

    // Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
    private static final CountRangeConfig salt_cfg = new CountRangeConfig(10, 32, 0, 64);
    private static final int salt_deposit_size = 9;


    public static void setupOreGen() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            // add salt deposits
            biome.addFeature(
                    GenerationStage.Decoration.UNDERGROUND_ORES,
                    Biome.createDecoratedFeature(
                            Feature.ORE,
                            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.SALT_DEPOSIT.getDefaultState(), salt_deposit_size),
                            Placement.COUNT_RANGE,
                            salt_cfg
                    )
            );
        }
    }
}