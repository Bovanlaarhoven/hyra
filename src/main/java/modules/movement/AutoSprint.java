package modules.movement;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class AutoSprint {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    public static void toggle(boolean state) {
        if (state && client.player != null && !client.player.isSprinting()) {
            client.player.sendMessage(Text.of("You are already sprinting!"), false);
            client.player.setSprinting(true);
        } else if (!state && client.player != null && client.player.isSprinting()) {
            client.player.sendMessage(Text.of("You are not sprinting!"), false);
            client.player.setSprinting(false);
        }
    }
}