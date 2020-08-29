package com.github.thedeathlycow.betterfood.effects;

import com.github.thedeathlycow.betterfood.init.Setup;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class ModEffects {

    public static final Effect SPICY = new SpicyEffect(EffectType.HARMFUL, 16711680);

    public static Effect[] EFFECTS = {
            Setup.setup(SPICY, "spicy")
    };

}
