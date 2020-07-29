package com.github.thedeathlycow.betterfood.crops.rice;

import com.github.thedeathlycow.betterfood.crops.WaterCropsTopBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

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
}
