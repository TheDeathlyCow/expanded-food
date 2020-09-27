package com.github.thedeathlycow.betterfood.init;

import com.github.thedeathlycow.betterfood.Main;
import com.github.thedeathlycow.betterfood.feature.LavaBerryFeature;
import com.github.thedeathlycow.betterfood.feature.RicePlantFeature;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.ChanceRangeConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Main.MODID)
public class ModFeatures {

    // features registry

    public static final Feature<NoFeatureConfig> RICE_PLANT = new RicePlantFeature(NoFeatureConfig.field_236558_a_);

    public static final Feature<NoFeatureConfig> LAVA_BERRY_BUSH = new LavaBerryFeature(NoFeatureConfig.field_236558_a_);

    public static Feature<?>[] FEATURES = {
            Setup.setup(RICE_PLANT, "rice_plant"),
            Setup.setup(LAVA_BERRY_BUSH, "lava_berry_bush")
    };

    private static final Biome[] NETHER_BIOMES = {
            Biomes.field_235254_j_, // nether wastes
            Biomes.field_235250_aA_, // warped forest
            Biomes.field_235253_az_ // crimson forest
    };

    public static void placeFeatures() {
        Biomes.SWAMP.addFeature(
                GenerationStage.Decoration.VEGETAL_DECORATION,
                ModFeatures.RICE_PLANT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE_RANGE.configure(new ChanceRangeConfig(0.75f, 60, 0, 65)))
        );

        for (Biome bushBiome : NETHER_BIOMES) {
            bushBiome.addFeature(
                    GenerationStage.Decoration.UNDERGROUND_DECORATION, ModFeatures.LAVA_BERRY_BUSH.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(5, 0, 0, 128)))
            );
        }

    }

}
