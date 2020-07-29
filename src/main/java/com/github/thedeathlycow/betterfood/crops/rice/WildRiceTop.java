package com.github.thedeathlycow.betterfood.crops.rice;

import com.github.thedeathlycow.betterfood.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class WildRiceTop extends RiceCropTopBlock {

    public WildRiceTop() {
        super();
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockOnPos = pos.down();
        BlockState blockOnState = worldIn.getBlockState(blockOnPos);
        Block blockOn = blockOnState.getBlock();

        return blockOn == ModBlocks.WILD_RICE_BASE;
    }
}
