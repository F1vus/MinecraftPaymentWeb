package net.fiv;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fiv.util.RabbitReceiver;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MinecraftPayment implements ModInitializer {
	public static final String MOD_ID = "minecraftpayment";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
        ServerLifecycleEvents.SERVER_STARTING.register(this::onServerStarting);

        LOGGER.info("Hello Fabric world!");
	}

    private void onServerStarting(MinecraftServer server) {
        try {
            RabbitReceiver.receive(server);
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }

}