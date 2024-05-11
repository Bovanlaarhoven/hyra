package org.bovl.hyra.client;

import modules.movement.AutoSprint;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Environment(EnvType.CLIENT)
public class HyraClient implements ClientModInitializer {
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void onInitializeClient() {
        executorService.scheduleAtFixedRate(this::onTick, 0, 50, TimeUnit.MILLISECONDS);
    }

    public void onTick() {

    }
}