package com.github.thedeathlycow.betterfood.foods;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ModFoods {

    public static final Food GREEN_APPLE;
    public static final Food CARAMEL;
    public static final Food CARAMEL_APPLE;

    static {
        GREEN_APPLE = (new Food.Builder()).hunger(4).saturation(0.3F).build();
        CARAMEL = (new Food.Builder()).hunger(1).saturation(0.1f).fastToEat().build();
        CARAMEL_APPLE = (new Food.Builder()).hunger(4).saturation(0.0f).setAlwaysEdible().effect(new EffectInstance(Effects.SPEED, 200, 1), 100).build();
    }

}
