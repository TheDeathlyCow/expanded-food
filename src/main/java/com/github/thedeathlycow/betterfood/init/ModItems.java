package com.github.thedeathlycow.betterfood.init;

import com.github.thedeathlycow.betterfood.Main;
import com.github.thedeathlycow.betterfood.foods.ModFoods;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.registries.ObjectHolder;

import java.util.List;
import java.util.Set;

@ObjectHolder(Main.MODID)
public class ModItems {

    public static Item[] ITEMS = {
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.APPLE)), "green_apple"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.PUMPKIN_PIE)), "apple_pie"),
            new BlockItem(ModBlocks.SALT_DEPOSIT, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(ModBlocks.SALT_DEPOSIT.getRegistryName()),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.MATERIALS)), "salt"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.CARAMEL)), "caramel"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.CARAMEL_APPLE)), "caramel_apple"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.MISC)), "rice_paddy"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.RICE)), "rice"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.SUSHI)), "salmon_sushi"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.SUSHI)), "chicken_sushi"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.PORKCHOP)), "calamari"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(Foods.COOKED_PORKCHOP)), "cooked_calamari"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.SUSHI)), "calamari_sushi"),
            Setup.setup(new Item(new Item.Properties().group(ItemGroup.FOOD).food(ModFoods.GAS_STATION_SUSHI)), "gas_station_sushi")
};

    public static final Item GREEN_APPLE = null;
    public static final Item APPLE_PIE = null;
    public static final Item SALT = null;
    public static final Item CARAMEL = null;
    public static final Item CARAMEL_APPLE = null;

    // rice items
    public static final Item RICE_PADDY = null;
    public static final Item RICE = null;
    public static final Item SALMON_SUSHI = null;
    public static final Item CHICKEN_SUSHI = null;
    public static final Item CALAMARI = null;
    public static final Item COOKED_CALAMARI = null;
    public static final Item CALAMARI_SUSHI = null;
    public static final Item GAS_STATION_SUSHI = null;

}