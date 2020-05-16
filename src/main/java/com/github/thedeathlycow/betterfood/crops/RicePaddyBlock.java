package com.github.thedeathlycow.betterfood.crops;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.HoeItem;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import java.util.Random;

/**
 * A farmland-like block that requires adjacent water to stay as a farmland block.
 */
public class RicePaddyBlock extends FarmlandBlock {

    public static final IntegerProperty MOISTURE = BlockStateProperties.MOISTURE_0_7;
    protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public RicePaddyBlock(Block.Properties builder) {
        super(builder);
        this.setDefaultState(this.stateContainer.getBaseState().with(MOISTURE, Integer.valueOf(7)));
    }

    public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
        LOGGER.debug("Rice paddy ticking.");
        if (!state.isValidPosition(worldIn, pos)) {
            super.turnToDirt(state, worldIn, pos);
        } else {
            if (!hasWater(worldIn, pos)) {
                super.turnToDirt(state, worldIn, pos);
            }
        }
    }

    private boolean hasCrops(IBlockReader worldIn, BlockPos pos) {
        BlockState state = worldIn.getBlockState(pos.up());
        return state.getBlock() instanceof net.minecraftforge.common.IPlantable && canSustainPlant(state, worldIn, pos, Direction.UP, (net.minecraftforge.common.IPlantable)state.getBlock());
    }

    private boolean hasWater(IBlockReader p_203943_1_, BlockPos p_203943_2_) {
        for (Direction direction : Direction.values()) {
            IFluidState ifluidstate = p_203943_1_.getFluidState(p_203943_2_.offset(direction));
            if (ifluidstate.isTagged(FluidTags.WATER)) {
                return true;
            }
        }
        return false;

    }

}