package com.github.thedeathlycow.betterfood.crops;

import com.github.thedeathlycow.betterfood.init.ModBlocks;
import com.github.thedeathlycow.betterfood.init.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Credit to Draco18s on the forge forums for part of this code.
 * Source: https://www.minecraftforge.net/forum/topic/77014-crops-114/
 */
public class WaterCropsBlock extends CropsBlock implements  ILiquidContainer {

    public final WaterCropsTopBlock topBlock;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;
    //private static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D );
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};

    public WaterCropsBlock(WaterCropsTopBlock topBlock) {
        super(Properties.create(Material.PLANTS).tickRandomly().hardnessAndResistance(0.0f).doesNotBlockMovement().sound(SoundType.WET_GRASS));
        this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
        this.topBlock = topBlock;
    }

    public IFluidState getFluidState(BlockState state) {
        return Fluids.WATER.getStillFluidState(false);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE_BY_AGE[state.get(this.getAgeProperty())];
    }

    public void grow(World worldIn, BlockPos pos, BlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }

        worldIn.setBlockState(pos, this.withAge(i), 2);
        this.updateTopBlock(state, worldIn, pos);
    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockOnPos = pos.down();
        BlockState blockOnState = worldIn.getBlockState(blockOnPos);
        Block blockOn = blockOnState.getBlock();

        Block blockAbove = worldIn.getBlockState(pos.up()).getBlock();

        return blockOn == ModBlocks.PADDY && (blockAbove == Blocks.AIR || blockAbove == ModBlocks.RICE_PLANT_TOP);
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
        return false;
    }

    public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, IFluidState fluidStateIn) {
        return false;
    }

    protected IItemProvider getSeedsItem() {
        return ModItems.RICE;
    }

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Blocks
        return state.getBlock() == ModBlocks.PADDY;
    }

    @Override
    public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
        //super.tick(state, worldIn, pos, random);
        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getLightSubtracted(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = getGrowthChance(this, worldIn, pos);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) {
                    worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                }
                this.updateTopBlock(state, worldIn, pos);
            }
            if (i == this.getMaxAge()) {
                this.updateTopBlock(state, worldIn, pos);
            }
        }
    }

    public void updateTopBlock(BlockState state, World worldIn, BlockPos pos) {
        int currAge = this.getAge(state);

        //WaterCropsTopBlock topBlock = ModBlocks.RICE_PLANT_TOP; // for some reason this.topBlock gives a null pointer exception, figure it out later

        if (currAge >= 3) {
            worldIn.setBlockState(pos.up(), this.topBlock.withAge(currAge), 2);
        }
    }

    private boolean hasTopBlock(BlockState state, World worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.up()).getBlock() == this.topBlock;
    }

}
