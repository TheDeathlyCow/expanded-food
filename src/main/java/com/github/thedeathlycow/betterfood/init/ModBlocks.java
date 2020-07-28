package com.github.thedeathlycow.betterfood.init;

import com.github.thedeathlycow.betterfood.Main;
import com.github.thedeathlycow.betterfood.blocks.EmptyBlock;
import com.github.thedeathlycow.betterfood.crops.PaddyBlock;
import com.github.thedeathlycow.betterfood.crops.WaterCropsBlock;
import com.github.thedeathlycow.betterfood.crops.WaterCropsTopBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Main.MODID)
public class  ModBlocks {

    public static final Block SALT_DEPOSIT = null;
    public static final WaterCropsTopBlock RICE_PLANT_TOP = new WaterCropsTopBlock();
    public static final WaterCropsBlock RICE_PLANT = null;
    public static final PaddyBlock PADDY = null;
    public static final EmptyBlock EMPTY_BLOCK = null;

    public static Block[] BLOCKS = {
            Setup.setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f)),"salt_deposit"),
            Setup.setup(new PaddyBlock(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.6f, 0.6f).sound(SoundType.GROUND).tickRandomly()), "paddy"),
            Setup.setup(RICE_PLANT_TOP, "rice_plant_top"),
            Setup.setup(new WaterCropsBlock(ModBlocks.RICE_PLANT_TOP), "rice_plant"),
            Setup.setup(new EmptyBlock(Block.Properties.create(Material.OCEAN_PLANT)), "empty_block")
    };

}