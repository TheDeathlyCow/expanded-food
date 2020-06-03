package com.github.thedeathlycow.betterfood.gen;

import com.github.thedeathlycow.betterfood.Main;
import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.DoublePlantConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;
import java.util.function.Function;

public class WaterCropFeature extends Feature<NoFeatureConfig> {


    public WaterCropFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {

        ServerWorld worldSever = (ServerWorld) worldIn;
        TemplateManager templateManager = worldSever.getStructureTemplateManager();
        Template template = templateManager.getTemplate(new ResourceLocation(Main.MODID, "structures/rice_plant/rice_plant"));

        if (worldIn.getBiome(pos) != Biomes.SWAMP && !isValidPosition(worldIn, pos)) {
            return false;
        }

        if (template == null) {
            Main.LOGGER.debug("Could not find structure at " + new ResourceLocation(Main.MODID, "structures/rice_plant/rice_plant"));
            return false;
        }

        PlacementSettings placementSettings = (new PlacementSettings()).setMirror(Mirror.NONE).setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk(null);
        template.addBlocksToWorld(worldIn, pos, placementSettings);
        return true;
    }

    private boolean isValidPosition(IWorld worldIn, BlockPos pos) {
        Block posBlock = worldIn.getBlockState(pos).getBlock();
        Block below = worldIn.getBlockState(pos.down()).getBlock();
        Block above = worldIn.getBlockState(pos.up()).getBlock();

        return posBlock == Blocks.WATER && below == Blocks.DIRT && above == Blocks.AIR;
    }
}
