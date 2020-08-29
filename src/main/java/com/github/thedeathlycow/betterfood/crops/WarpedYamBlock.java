package com.github.thedeathlycow.betterfood.crops;

import com.github.thedeathlycow.betterfood.init.ModBlocks;
import com.github.thedeathlycow.betterfood.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class WarpedYamBlock extends CropsBlock {

    public static final IntegerProperty WARPED_YAM_AGE = BlockStateProperties.AGE_0_3;
    private static final VoxelShape[] SHAPE = new VoxelShape[]{Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D)};

    public WarpedYamBlock(Properties builder) {
        super(builder);
    }

    @Override
    protected IItemProvider getSeedsItem() {
        return ModItems.WARPED_YAM;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (random.nextInt(3) != 0) {
            super.randomTick(state, worldIn, pos, random);
        }
    }

    public void grow(World worldIn, BlockPos pos, BlockState state) {

        int newAge = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int maxAge = this.getMaxAge();
        if (newAge > maxAge) {
            newAge = maxAge;
        }

        worldIn.setBlockState(pos, this.withAge(newAge), 2);
    }

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.isIn(ModBlocks.NETHERRACK_FARMLAND);
    }

    public int getMaxAge() {
        return 3;
    }

    public IntegerProperty getAgeProperty() {
        return WARPED_YAM_AGE;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(WARPED_YAM_AGE);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE[state.get(this.getAgeProperty())];
    }

    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockOnPos = pos.down();
        BlockState blockOnState = worldIn.getBlockState(blockOnPos);
        Block blockOn = blockOnState.getBlock();
        return blockOn == ModBlocks.NETHERRACK_FARMLAND;
    }
}
