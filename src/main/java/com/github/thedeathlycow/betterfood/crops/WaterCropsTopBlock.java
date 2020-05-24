package com.github.thedeathlycow.betterfood.crops;

import com.github.thedeathlycow.betterfood.init.ModBlocks;
import com.github.thedeathlycow.betterfood.init.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.Random;

public class WaterCropsTopBlock extends CropsBlock {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;
    //private static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 32.0D, 16.0D );
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 0.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D)};

    public WaterCropsTopBlock() {
        super(Properties.create(Material.PLANTS).hardnessAndResistance(0.0f).doesNotBlockMovement().sound(SoundType.WET_GRASS));
        this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(3)));
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockOnPos = pos.down();
        BlockState blockOnState = worldIn.getBlockState(blockOnPos);
        Block blockOn = blockOnState.getBlock();

        return blockOn == ModBlocks.RICE_PLANT;
    }

    /**
     * Called just before the block is set to air.
     * @param worldIn The world that the block was destroyed
     * @param pos The position of the block that was destroyed
     * @param state The state of the block that was destroyed
     * @param player The player who harvested the block
     */
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        worldIn.setBlockState(pos.down(), Blocks.WATER.getDefaultState(), 2);
    }

    @Override
    public int getAge(BlockState state) {
        return state.get(this.getAgeProperty());
    }

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() == ModBlocks.PADDY;
    }

    protected IItemProvider getSeedsItem() {
        return ModItems.RICE;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE_BY_AGE[state.get(this.getAgeProperty())];
    }

}
