package modules.misc;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class ChestStealer {
    public static void toggle(boolean state) {
        if (state) {
            MinecraftClient.getInstance().player.sendMessage(Text.of("Started stealing from chest."), false);
        } else {
            MinecraftClient.getInstance().player.sendMessage(Text.of("Stopped stealing from chest."), false);
        }
    }
}
