package com.github.thedeathlycow.betterfood.init;

import com.github.thedeathlycow.betterfood.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Main.MODID)
public class ModBlocks {
    public static Block[] BLOCKS = {
            Setup.setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f)),"salt_deposit"),
            Setup.setup(new Block(Block.Properties.create(Material.OCEAN_PLANT).hardnessAndResistance(1.0f, 1.0f)), "rice_paddy")
    };

    public static final Block SALT_DEPOSIT = null;
    public static final Block RICE_PADDY = null;
}
