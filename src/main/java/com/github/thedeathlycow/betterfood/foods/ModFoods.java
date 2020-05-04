package com.github.thedeathlycow.betterfood.foods;

import net.minecraft.item.Food;

public class ModFoods {

    public static final Food GREEN_APPLE;
    public static final Food CARAMEL;

    static {
        GREEN_APPLE = (new Food.Builder()).hunger(4).saturation(0.3F).build();
        CARAMEL = (new Food.Builder()).hunger(1).saturation(0.1f).fastToEat().build();
    }

}
