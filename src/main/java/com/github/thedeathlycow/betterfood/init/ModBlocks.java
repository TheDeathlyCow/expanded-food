package com.github.thedeathlycow.betterfood.init;

import com.github.thedeathlycow.betterfood.Main;
import com.github.thedeathlycow.betterfood.crops.PaddyBlock;
import com.github.thedeathlycow.betterfood.crops.WaterCropsBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Main.MODID)
public class  ModBlocks {
    public static Block[] BLOCKS = {
            Setup.setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f)),"salt_deposit"),
            Setup.setup(new WaterCropsBlock(), "rice_plant"),
            Setup.setup(new PaddyBlock(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.6f, 0.6f).sound(SoundType.GROUND).tickRandomly()), "paddy")
    };

    public static final Block SALT_DEPOSIT = null;
    public static final WaterCropsBlock RICE_PLANT = null;
    public static final PaddyBlock PADDY = null;
}
