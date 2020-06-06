package com.github.thedeathlycow.betterfood;

import com.github.thedeathlycow.betterfood.gen.ModGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Main.MODID)
public final class Main {

    public static final String MODID = "better-food";

    public static final Logger LOGGER = LogManager.getLogger(MODID);



    public Main() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        LOGGER.debug("HELLO from BETTER FOOD");
    }

    private void setup(final FMLCommonSetupEvent event) {
        ModGenerator.setupOreGen();
        LOGGER.info("Setup method registered.");
    }
}

