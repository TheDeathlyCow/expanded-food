package com.github.thedeathlycow.betterfood.effects;

import com.github.thedeathlycow.betterfood.init.Setup;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.registry.Registry;

public class ModEffects {

    public static final Effect SPICY = new SpicyEffect(EffectType.HARMFUL, 16711680);

    public static Effect[] EFFECTS = {
            Setup.setup(SPICY, "spicy")
    };


//    private static Effect register(int id, String key, Effect effectIn) {
//        return Registry.register(Registry.EFFECTS, id, key, effectIn);
//    }
}
