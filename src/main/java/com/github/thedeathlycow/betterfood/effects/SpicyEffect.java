package com.github.thedeathlycow.betterfood.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class SpicyEffect extends Effect {

    protected SpicyEffect(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
    }

    /**
     * Sets the entity on fire.
     */
    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        int fireTime = 1;
        entityLivingBaseIn.setFire(fireTime);
    }

    /**
     * Checks if the Spicy effect is ready to be applied this tick.
     */
    @Override
    public boolean isReady(int duration, int amplifier) {
        if (this == ModEffects.SPICY) {
            int k = 20 >> amplifier;
            if (k > 0) {
                return duration % k == 0;
            } else {
                return true;
            }
        }
        return false;
    }
}
