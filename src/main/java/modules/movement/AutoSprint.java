package modules.movement;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class AutoSprint {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static void toggle(boolean state) {
        if (client.player != null) {
            client.player.setSprinting(state);
            String message = state ? "AutoSprint enabled!" : "AutoSprint disabled!";
            client.player.sendMessage(Text.of(message), false);
        }
    }
}