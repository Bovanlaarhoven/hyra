package modules.movement;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class AutoSprint {
    private final MinecraftClient client = MinecraftClient.getInstance();

    public void onTick() {
        if (client.player == null) return;

        if (client.options.keyForward.isPressed()) {
            client.player.setSprinting(true);
        }
    }
}
