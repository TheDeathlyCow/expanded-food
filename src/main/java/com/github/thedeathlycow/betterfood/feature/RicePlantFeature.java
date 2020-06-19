package com.github.thedeathlycow.betterfood.feature;

import com.github.thedeathlycow.betterfood.init.ModBlocks;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DeadBushBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.DeadBushFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MelonFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class RicePlantFeature extends Feature<NoFeatureConfig> {

    public RicePlantFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn) {
        super(configIn);
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {

//        for(int i = 0; i < 64; ++i) {
//            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
//            BlockState paddy_state = ModBlocks.PADDY.getDefaultState();
//            Block rice_crop = ModBlocks.RICE_PLANT;
//            if (worldIn.getBlockState(blockpos).getMaterial().isReplaceable() && worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER) {
//                if (rice_crop.isValidPosition(rice_crop.getDefaultState(), worldIn, blockpos)) {
//                    worldIn.setBlockState(blockpos.down(), paddy_state, 2);
//                    worldIn.setBlockState(blockpos, rice_crop.getDefaultState(), 2);
//                }
////                worldIn.setBlockState(blockpos, blockstate, 2);
//            }
//        }

        for(int i = 0; i < 64; ++i) {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            BlockState blockstate = ModBlocks.RICE_PLANT.withAge(7);
            if (worldIn.getBlockState(blockpos) == Blocks.AIR.getDefaultState() && worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.GRASS_BLOCK) {
                blockpos = blockpos.down();
                worldIn.setBlockState(blockpos.down(), ModBlocks.PADDY.getDefaultState(), 2);
                worldIn.setBlockState(blockpos, blockstate, 2);
                worldIn.setBlockState(blockpos.up(), ModBlocks.RICE_PLANT_TOP.withAge(7), 2);
            }
        }
        return true;

    }
}
