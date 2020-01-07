package com.github.thedeathlycow.betterfood.foods;

import net.minecraft.item.Food;

public class ModFoods {

    public static final Food GREEN_APPLE;

    static {
        GREEN_APPLE = (new Food.Builder()).hunger(4).saturation(0.3F).build();
    }

}
