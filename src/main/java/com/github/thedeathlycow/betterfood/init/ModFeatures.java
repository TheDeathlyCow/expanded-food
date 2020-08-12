package com.github.thedeathlycow.betterfood.init;

import com.github.thedeathlycow.betterfood.Main;
import com.github.thedeathlycow.betterfood.feature.RicePlantFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Main.MODID)
public class ModFeatures {

    // features registry

    public static final Feature<NoFeatureConfig> RICE_PLANT = new RicePlantFeature(NoFeatureConfig.field_236558_a_);

    public static Feature<?>[] FEATURES = {
            Setup.setup(RICE_PLANT, "rice_plant")
    };

}
