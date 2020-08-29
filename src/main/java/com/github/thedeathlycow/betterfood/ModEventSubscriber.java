package com.github.thedeathlycow.betterfood;

import com.github.thedeathlycow.betterfood.effects.ModEffects;
import com.github.thedeathlycow.betterfood.init.ModBlocks;
import com.github.thedeathlycow.betterfood.init.ModFeatures;
import com.github.thedeathlycow.betterfood.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.ChanceRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;

@EventBusSubscriber(modid = Main.MODID, bus = EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber {

    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.ITEMS);
    }

    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS);
    }

    @SubscribeEvent
    public static void onRegisterFeatures(RegistryEvent.Register<Feature<?>> event) {
        event.getRegistry().registerAll(ModFeatures.FEATURES);
    }

    @SubscribeEvent
    public static void onRegisterEffects(RegistryEvent.Register<Effect> event) {
        event.getRegistry().registerAll(ModEffects.EFFECTS);
    }

    @SubscribeEvent
    public static void FMLClientSetupEvent(final FMLClientSetupEvent event) {
        if (FMLEnvironment.dist == Dist.CLIENT) {
            RenderTypeLookup.setRenderLayer(ModBlocks.RICE_PLANT, RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.RICE_PLANT_TOP, RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.WILD_RICE_BASE, RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.WILD_RICE_TOP, RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.WARPED_YAM, RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.LAVA_BERRY_BUSH, RenderType.getCutout());
        }
    }

    @SubscribeEvent
    public static void FMLLoadCompleteEvent(FMLLoadCompleteEvent event) {
        Biomes.SWAMP.addFeature(
                GenerationStage.Decoration.VEGETAL_DECORATION,
                ModFeatures.RICE_PLANT.withConfiguration(new NoFeatureConfig()).withPlacement(Placement.CHANCE_RANGE.configure(new ChanceRangeConfig(100.0f, 60, 0, 65)))
//                Biome.createDecoratedFeature(ModFeatures.RICE_PLANT,
//                        new NoFeatureConfig(),
//                        Placement.CHANCE_RANGE,
//                        new ChanceRangeConfig(100.0f, 60, 0, 65)
//                )
        );
    }
}
