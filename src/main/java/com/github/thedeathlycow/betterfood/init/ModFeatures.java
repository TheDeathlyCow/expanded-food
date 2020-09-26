package com.github.thedeathlycow.betterfood.init;

import com.github.thedeathlycow.betterfood.Main;
import com.github.thedeathlycow.betterfood.crops.LavaBerryBlock;
import com.github.thedeathlycow.betterfood.feature.LavaBerryFeature;
import com.github.thedeathlycow.betterfood.feature.RicePlantFeature;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.CrimsonForestBiome;
import net.minecraft.world.biome.NetherWastesBiome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
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
                ModFeatures.RICE_PLANT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE_RANGE.configure(new ChanceRangeConfig(100.0f, 60, 0, 65)))
        );

        for (Biome bushBiome : NETHER_BIOMES) {
            bushBiome.addFeature(
                    GenerationStage.Decoration.VEGETAL_DECORATION, ModFeatures.LAVA_BERRY_BUSH.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 128)))
            );
        }
    }

}
