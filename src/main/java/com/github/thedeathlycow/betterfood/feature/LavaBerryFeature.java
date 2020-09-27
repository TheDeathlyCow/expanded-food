package com.github.thedeathlycow.betterfood.feature;

import com.github.thedeathlycow.betterfood.crops.LavaBerryBlock;
import com.github.thedeathlycow.betterfood.init.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.biome.CrimsonForestBiome;
import net.minecraft.world.biome.NetherWastesBiome;
import net.minecraft.world.biome.SoulSandBiome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;

import java.util.Random;

public class LavaBerryFeature extends Feature<NoFeatureConfig> {
    public LavaBerryFeature(Codec<NoFeatureConfig> config) {
        super(config);
    }

    /**
     * I think this is the place method.
     */
    @Override
    public boolean func_230362_a_(ISeedReader seedReader, StructureManager structureManager, ChunkGenerator chunkGenerator, Random rand, BlockPos pos, NoFeatureConfig config) {

        for (int i = 0; i < 64; ++i) {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            BlockState blockstate = ModBlocks.LAVA_BERRY_BUSH.getDefaultState().with(LavaBerryBlock.AGE, Integer.valueOf(3));
            if (isValidGround(seedReader, blockpos)) {
                seedReader.setBlockState(blockpos, blockstate, 2);
            }
        }
        return true;

    }

    private boolean isValidGround(ISeedReader seedReader, BlockPos pos) {
        return (seedReader.getBlockState(pos.down()).getBlock() == Blocks.NETHERRACK ||
                seedReader.getBlockState(pos.down()).getBlock() == Blocks.WARPED_NYLIUM ||
                seedReader.getBlockState(pos.down()).getBlock() == Blocks.CRIMSON_NYLIUM) &&
                (seedReader.getBlockState(pos).getBlock() == Blocks.AIR);
    }
}
