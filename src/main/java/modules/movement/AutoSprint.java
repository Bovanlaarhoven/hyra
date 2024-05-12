package modules.movement;

import net.minecraft.client.MinecraftClient;

public class AutoSprint {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static void toggle(boolean state) {
        if (client.player != null) {
            if (state) {
                client.player.setSprinting(true);
            } else {
                return;
            }
        }
    }
}