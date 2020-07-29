package com.github.thedeathlycow.betterfood.crops.rice;

import com.github.thedeathlycow.betterfood.crops.WaterCropsTopBlock;
import com.github.thedeathlycow.betterfood.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class WildRiceBase extends RiceCropBlock {
    public WildRiceBase(WaterCropsTopBlock topBlock) {
        super(topBlock);
    }

    @Override
    protected IItemProvider getSeedsItem() {
        return null;
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() == Blocks.DIRT;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {

        BlockPos blockOnPos = pos.down();
        BlockState blockOnState = worldIn.getBlockState(blockOnPos);
        Block blockOn = blockOnState.getBlock();

        Block blockAbove = worldIn.getBlockState(pos.up()).getBlock();
        return blockOn == Blocks.DIRT && (blockAbove == Blocks.AIR || blockAbove == ModBlocks.WILD_RICE_TOP);
    }
}
