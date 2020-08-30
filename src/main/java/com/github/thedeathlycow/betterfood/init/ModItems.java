package com.github.thedeathlycow.betterfood.init;

import com.github.thedeathlycow.betterfood.Main;
import com.github.thedeathlycow.betterfood.foods.ModFoods;
import com.github.thedeathlycow.betterfood.items.tools.HomiItem;
import net.minecraft.item.*;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Main.MODID)
public class ModItems {

    public static final Item GREEN_APPLE = null;
    public static final Item APPLE_PIE = null;
    public static final Item SALT = null;
    public static final Item CARAMEL = null;
    public static final Item CARAMEL_APPLE = null;

    // rice items
    public static final Item RICE = null;
    public static final Item SALMON_SUSHI = null;
    public static final Item CHICKEN_SUSHI = null;
    public static final Item CALAMARI = null;
    public static final Item COOKED_CALAMARI = null;
    public static final Item CALAMARI_SUSHI = null;
    public static final Item GAS_STATION_SUSHI = null;
    public static final Item RICE_BOWL = null;

    // homi
    public static final Item WOODEN_HOMI = null;
    public static final Item STONE_HOMI = null;
    public static final Item IRON_HOMI = null;
    public static final Item DIAMOND_HOMI = null;
    public static final Item GOLDEN_HOMI = null;

    // nether crops
//    public static final Item WARPED_YAM_SEEDS = null;
//    public static final Item WARPED_YAM = new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.BEETROOT));
    public static final Item WARPED_YAM = new BlockNamedItem(ModBlocks.WARPED_YAM, new Item.Properties().group(ItemGroup.FOOD).food(Foods.POTATO));
    public static final Item LAVA_BERRIES = new BlockNamedItem(ModBlocks.LAVA_BERRY_BUSH, (new Item.Properties()).group(ItemGroup.FOOD).food(ModFoods.LAVA_BERRIES).maxStackSize(16));
    public static final Item CRIMSON_REAPER = new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.CRIMSON_REAPER));

    public static Item[] ITEMS = {
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.APPLE)), "green_apple"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.PUMPKIN_PIE)), "apple_pie"),
            new BlockItem(ModBlocks.SALT_DEPOSIT, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(ModBlocks.SALT_DEPOSIT.getRegistryName()),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.MATERIALS)), "salt"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.CARAMEL)), "caramel"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.CARAMEL_APPLE)), "caramel_apple"),
            Setup.setup(new BlockNamedItem(ModBlocks.RICE_PLANT, new Item.Properties().group(ItemGroup.MATERIALS)), "rice"),
            Setup.setup(new SoupItem(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.RICE_BOWL).maxStackSize(64)), "rice_bowl"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.SUSHI)), "salmon_sushi"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.SUSHI)), "chicken_sushi"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.PORKCHOP)), "calamari"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.COOKED_PORKCHOP)), "cooked_calamari"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.SUSHI)), "calamari_sushi"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.GAS_STATION_SUSHI)), "gas_station_sushi"),
            new BlockItem(ModBlocks.PADDY, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(ModBlocks.PADDY.getRegistryName()),
            Setup.setup(new HomiItem(ItemTier.WOOD, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)), "wooden_homi"),
            Setup.setup(new HomiItem(ItemTier.STONE, -2.0f, new Item.Properties().group(ItemGroup.TOOLS)), "stone_homi"),
            Setup.setup(new HomiItem(ItemTier.IRON, -1.0f, new Item.Properties().group(ItemGroup.TOOLS)), "iron_homi"),
            Setup.setup(new HomiItem(ItemTier.DIAMOND, 0.0f, new Item.Properties().group(ItemGroup.TOOLS)), "diamond_homi"),
            Setup.setup(new HomiItem(ItemTier.GOLD, -3.0f, new Item.Properties().group(ItemGroup.TOOLS)), "golden_homi"),
//            Setup.setup(new BlockNamedItem(ModBlocks.WARPED_YAM, new Item.Properties().group(ItemGroup.MATERIALS)), "warped_yam_seeds"),
            Setup.setup(WARPED_YAM, "warped_yam"),
            new BlockItem(ModBlocks.NETHERRACK_FARMLAND, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(ModBlocks.NETHERRACK_FARMLAND.getRegistryName()),
            Setup.setup(LAVA_BERRIES, "lava_berries"),
            Setup.setup(CRIMSON_REAPER, "crimson_reaper")
    };
}