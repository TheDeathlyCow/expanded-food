package com.github.thedeathlycow.betterfood.crops;

import com.github.thedeathlycow.betterfood.init.ModBlocks;
import com.github.thedeathlycow.betterfood.init.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

/**
 * Credit to Draco18s on the forge forums for this code.
 * Source: https://www.minecraftforge.net/forum/topic/77014-crops-114/
 */
public class RiceCropBlock extends CropsBlock {

    public RiceCropBlock() {
        super(Properties.create(Material.PLANTS).tickRandomly().hardnessAndResistance(0.0f).doesNotBlockMovement().sound(SoundType.WET_GRASS));
    }

    protected IItemProvider getSeedsItem() {
        return ModItems.RICE;
    }

    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.getBlock() == ModBlocks.RICE_PADDY;
    }
}
