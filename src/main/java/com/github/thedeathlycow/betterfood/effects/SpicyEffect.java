package com.github.thedeathlycow.betterfood.effects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;

import javax.annotation.Nullable;

public class SpicyEffect extends Effect {

    protected SpicyEffect(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        int fireTime = 4;
        entityLivingBaseIn.setFire(fireTime);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        if (this == ModEffects.SPICY) {
            int k = 50 >> amplifier;
            if (k > 0) {
                return duration % k == 0;
            } else {
                return true;
            }
        }
        return false;
    }
}
