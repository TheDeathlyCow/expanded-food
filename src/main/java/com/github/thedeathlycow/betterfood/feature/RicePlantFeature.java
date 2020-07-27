package com.github.thedeathlycow.betterfood.feature;

import com.github.thedeathlycow.betterfood.init.ModBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class RicePlantFeature extends Feature<NoFeatureConfig> {

    public RicePlantFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn) {
        super(configIn);
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        // spawns rice in a melon-like pattern in shallow water
        for (int i = 0; i < 64; ++i) {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            BlockState blockstate = ModBlocks.RICE_PLANT.withAge(7);
            if ((worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER || worldIn.getBlockState(blockpos).getBlock() == Blocks.SEAGRASS) && worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.DIRT && worldIn.getBlockState(blockpos.up()).getBlock() == Blocks.AIR) {
                worldIn.setBlockState(blockpos.down(), ModBlocks.PADDY.getDefaultState(), 2);
                worldIn.setBlockState(blockpos, blockstate, 2);
                worldIn.setBlockState(blockpos.up(), ModBlocks.RICE_PLANT_TOP.withAge(7), 2);
            }
        }
        return true;
    }
}
