package com.github.thedeathlycow.betterfood.crops;

import com.github.thedeathlycow.betterfood.init.ModItems;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IItemProvider;

/**
 * Credit to Draco18s on the forge forums for this code.
 * Source: https://www.minecraftforge.net/forum/topic/77014-crops-114/
 */
public class RiceCropBlock extends CropsBlock {

    public RiceCropBlock() {
        super(Properties.create(Material.PLANTS).tickRandomly().hardnessAndResistance(0.0f).doesNotBlockMovement().sound(SoundType.CROP));
    }

    protected IItemProvider getSeedsItem() {
        return ModItems.RICE;
    }
}
