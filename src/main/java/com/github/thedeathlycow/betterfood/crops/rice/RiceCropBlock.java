package com.github.thedeathlycow.betterfood.crops.rice;

import com.github.thedeathlycow.betterfood.crops.WaterCropsBlock;
import com.github.thedeathlycow.betterfood.crops.WaterCropsTopBlock;
import com.github.thedeathlycow.betterfood.init.ModBlocks;
import com.github.thedeathlycow.betterfood.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class RiceCropBlock extends WaterCropsBlock {

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public RiceCropBlock(WaterCropsTopBlock topBlock) {
        super(topBlock);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE_BY_AGE[state.get(this.getAgeProperty())];
    }

    protected IItemProvider getSeedsItem() {
        return ModItems.RICE;
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {

        BlockPos blockOnPos = pos.down();
        BlockState blockOnState = worldIn.getBlockState(blockOnPos);
        Block blockOn = blockOnState.getBlock();

        Block blockAbove = worldIn.getBlockState(pos.up()).getBlock();

        if (this.getAge(state) >= 3) {
            return blockOn == ModBlocks.PADDY && blockAbove == ModBlocks.RICE_PLANT_TOP;
        }
        return blockOn == ModBlocks.PADDY && blockAbove == Blocks.AIR;
    }
}
