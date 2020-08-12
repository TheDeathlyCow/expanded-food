package com.github.thedeathlycow.betterfood.feature;

import com.github.thedeathlycow.betterfood.init.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;

import java.util.Random;

public class RicePlantFeature extends Feature<NoFeatureConfig> {

    public RicePlantFeature(Codec<NoFeatureConfig> configIn) {
        super(configIn);
    }

    @Override
    public boolean func_230362_a_(ISeedReader seedReader, StructureManager structureManager, ChunkGenerator chunkGenerator, Random rand, BlockPos pos, NoFeatureConfig config) {
        for (int i = 0; i < 64; ++i) {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            BlockState blockstate = ModBlocks.WILD_RICE_BASE.withAge(7);
            if ((seedReader.getBlockState(blockpos).getBlock() == Blocks.WATER || seedReader.getBlockState(blockpos).getBlock() == Blocks.SEAGRASS) && seedReader.getBlockState(blockpos.down()).getBlock() == Blocks.DIRT && seedReader.getBlockState(blockpos.up()).getBlock() == Blocks.AIR) {
                seedReader.setBlockState(blockpos.down(), Blocks.DIRT.getDefaultState(), 2);
                seedReader.setBlockState(blockpos, blockstate, 2);
                seedReader.setBlockState(blockpos.up(), ModBlocks.WILD_RICE_TOP.withAge(7), 2);
            }
        }
        return true;
    }
}
