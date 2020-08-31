package com.github.thedeathlycow.betterfood.foods;

import com.github.thedeathlycow.betterfood.effects.ModEffects;
import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ModFoods {

    // apple stuff
    public static final Food GREEN_APPLE;
    public static final Food CARAMEL;
    public static final Food CARAMEL_APPLE;

    public static final Food RICE_BOWL;
    public static final Food SUSHI;
    public static final Food GAS_STATION_SUSHI;

    public static final Food LAVA_BERRIES;
    public static final Food WARPED_YAM;

    public static final Food CRIMSON_REAPER;

    private static EffectInstance[] gasStationSushiEffects = {
            new EffectInstance(Effects.POISON, 600, 1),
            new EffectInstance(Effects.BLINDNESS, 300, 1),
            new EffectInstance(Effects.NAUSEA, 300, 2),
            new EffectInstance(Effects.HUNGER, 600, 2),
            new EffectInstance(Effects.INSTANT_DAMAGE, 20, 3)
    };

    static {
        GREEN_APPLE = (new Food.Builder()).hunger(4).saturation(0.3F).build();
        CARAMEL = (new Food.Builder()).hunger(1).saturation(0.1f).fastToEat().build();
        CARAMEL_APPLE = (new Food.Builder()).hunger(4).saturation(0.0f).setAlwaysEdible().effect(new EffectInstance(Effects.SPEED, 200, 1), 1).build();
        RICE_BOWL = (new Food.Builder()).hunger(8).saturation(0.5f).build();
        SUSHI = (new Food.Builder()).hunger(6).saturation(0.5f).build();
        GAS_STATION_SUSHI = (new Food.Builder()).hunger(4).saturation(0.0f).effect(gasStationSushiEffects[0], 0.5f).effect(gasStationSushiEffects[1], 0.5f).effect(gasStationSushiEffects[2], 0.5f).effect(gasStationSushiEffects[3], 0.5f).build();
        LAVA_BERRIES = (new Food.Builder()).hunger(1).saturation(0.3f).effect(new EffectInstance(Effects.FIRE_RESISTANCE, 5*20, 0), 0.8f).build();
        WARPED_YAM = (new Food.Builder()).hunger(4).saturation(0.6f).build();
        CRIMSON_REAPER = (new Food.Builder()).hunger(5).saturation(0.7f).effect(new EffectInstance(ModEffects.SPICY, 100, 0), 1).build();
    }

}
