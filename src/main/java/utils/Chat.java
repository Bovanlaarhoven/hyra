package utils;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class Chat {
    public static void sendChatMessage(String message) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null && client.player != null && message != null && !message.isEmpty()) {
            client.player.sendMessage(Text.of(message), false);
        }
    }
}
