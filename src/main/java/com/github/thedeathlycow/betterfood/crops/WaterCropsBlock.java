package com.github.thedeathlycow.betterfood.crops;

import com.github.thedeathlycow.betterfood.Main;
import com.github.thedeathlycow.betterfood.init.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

/**
 * Credit to Draco18s on the forge forums for part of this code.
 * Source: https://www.minecraftforge.net/forum/topic/77014-crops-114/
 */
public abstract class WaterCropsBlock extends CropsBlock implements ILiquidContainer {

    public final WaterCropsTopBlock topBlock;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;

    public WaterCropsBlock(WaterCropsTopBlock topBlock) {
        super(Properties.create(Material.PLANTS).tickRandomly().hardnessAndResistance(0.0f).doesNotBlockMovement().sound(SoundType.WET_GRASS));
        this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
        this.topBlock = topBlock;
    }

    public FluidState getFluidState(BlockState state) {
        return Fluids.WATER.getStillFluidState(false);
    }

    public abstract VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context);

    public void grow(World worldIn, BlockPos pos, BlockState state) {
        int age = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int maxAge = this.getMaxAge();
        if (age > maxAge) {
            age = maxAge;
        }

        worldIn.setBlockState(pos, this.withAge(age), 2);
        this.updateTopBlock((ServerWorld)worldIn, pos, age);
    }

    public abstract boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos);

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
        return false;
    }

    public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
        return false;
    }

    protected abstract IItemProvider getSeedsItem();

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() == ModBlocks.PADDY;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        //super.tick(state, worldIn, pos, random);
        if (!worldIn.isAreaLoaded(pos, 1))
            return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getLightSubtracted(pos, 0) >= 9) {
            int age = this.getAge(state);
            if (age < this.getMaxAge()) {
                float f = getGrowthChance(this, worldIn, pos);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, random.nextInt((int) (25.0F / f) + 1) == 0)) {
                    worldIn.setBlockState(pos, this.withAge(age + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                }
            }
            this.updateTopBlock(worldIn, pos, this.getAge(state));
        }
    }

    private void updateTopBlock(ServerWorld worldIn, BlockPos pos, int currAge) {
        if (currAge >= 3) {
            worldIn.setBlockState(pos.up(), this.topBlock.withAge(currAge));
        }
    }

}
