package com.github.thedeathlycow.betterfood.init;

import com.github.thedeathlycow.betterfood.Main;
import com.github.thedeathlycow.betterfood.crops.RiceCropBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Main.MODID)
public class ModBlocks {
    public static Block[] BLOCKS = {
            Setup.setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f)),"salt_deposit"),
            Setup.setup(new RiceCropBlock(), "rice_plant")
    };

    public static final Block SALT_DEPOSIT = null;
    public static final RiceCropBlock RICE_PLANT = null;
}
