package com.github.thedeathlycow.betterfood.init;

import com.github.thedeathlycow.betterfood.Main;
import com.github.thedeathlycow.betterfood.blocks.EmptyBlock;
import com.github.thedeathlycow.betterfood.blocks.NetherrackFarmlandBlock;
import com.github.thedeathlycow.betterfood.blocks.PaddyBlock;
import com.github.thedeathlycow.betterfood.crops.AshYamBlock;
import com.github.thedeathlycow.betterfood.crops.LavaBerryBlock;
import com.github.thedeathlycow.betterfood.crops.WaterCropsBlock;
import com.github.thedeathlycow.betterfood.crops.WaterCropsTopBlock;
import com.github.thedeathlycow.betterfood.crops.rice.RiceCropBlock;
import com.github.thedeathlycow.betterfood.crops.rice.RiceCropTopBlock;
import com.github.thedeathlycow.betterfood.crops.rice.WildRiceBase;
import com.github.thedeathlycow.betterfood.crops.rice.WildRiceTop;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Main.MODID)
public class  ModBlocks {

    public static final Block SALT_DEPOSIT = null;
    public static final WaterCropsTopBlock RICE_PLANT_TOP = new RiceCropTopBlock();
    public static final WaterCropsBlock RICE_PLANT = new RiceCropBlock(RICE_PLANT_TOP);
    public static final PaddyBlock PADDY = null;
    public static final EmptyBlock EMPTY_BLOCK = null;
    public static final WaterCropsTopBlock WILD_RICE_TOP = new WildRiceTop();
    public static final WaterCropsBlock WILD_RICE_BASE = new WildRiceBase(WILD_RICE_TOP);
    public static final Block NETHERRACK_FARMLAND = null;
    public static final Block ASH_YAM = new AshYamBlock(AbstractBlock.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance().sound(SoundType.field_235591_M_));
    public static final Block LAVA_BERRIES = new LavaBerryBlock(AbstractBlock.Properties.create(Material.PLANTS).tickRandomly().zeroHardnessAndResistance().sound(SoundType.CROP));

    public static Block[] BLOCKS = {
            Setup.setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f)),"salt_deposit"),
            Setup.setup(new PaddyBlock(Block.Properties.create(Material.EARTH).hardnessAndResistance(0.6f, 0.6f).sound(SoundType.GROUND).tickRandomly()), "paddy"),
            Setup.setup(RICE_PLANT_TOP, "rice_plant_top"),
            Setup.setup(RICE_PLANT, "rice_plant"),
            Setup.setup(new EmptyBlock(Block.Properties.create(Material.OCEAN_PLANT)), "empty_block"),
            Setup.setup(WILD_RICE_TOP, "wild_rice_top"),
            Setup.setup(WILD_RICE_BASE, "wild_rice_base"),
            Setup.setup(new NetherrackFarmlandBlock(Block.Properties.create(Material.ROCK, MaterialColor.NETHERRACK).func_235838_a_((property) -> {
                if (property.get(NetherrackFarmlandBlock.HEAT) == 7) return 2; else return 0;
            }).tickRandomly().hardnessAndResistance(0.4F).sound(SoundType.field_235589_K_)), "netherrack_farmland"),
            Setup.setup(ASH_YAM, "ash_yam"),
            Setup.setup(LAVA_BERRIES, "lava_berries")
};

}