package org.bovl.hyra.client;

import modules.movement.AutoSprint;
import org.lwjgl.glfw.GLFW;
import utils.keybind;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Environment(EnvType.CLIENT)
public class HyraClient implements ClientModInitializer {
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void onInitializeClient() {
        keybind.createKeybind("auto_sprint", GLFW.GLFW_KEY_C);
        executorService.scheduleAtFixedRate(this::onTick, 0, 50, TimeUnit.MILLISECONDS);
    }

    public void onTick() {
        AutoSprint.toggle(keybind.isToggled("auto_sprint"));
    }
}