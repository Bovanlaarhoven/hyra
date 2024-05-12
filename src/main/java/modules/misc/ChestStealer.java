package modules.misc;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.slot.SlotActionType;
import utils.Chat;

public class ChestStealer {
    private static boolean stealing = false;

    public static void toggle(boolean state) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (!(client.currentScreen instanceof GenericContainerScreen)) {
            stealing = false;
            return;
        }

        stealing = state;
        if (state) {
            PlayerInventory playerInventory = client.player.getInventory();
            GenericContainerScreen chestScreen = (GenericContainerScreen) client.currentScreen;
            int ChestSlots = (chestScreen.getScreenHandler().slots.get(0).inventory.size());
            for (int i = 0; i < ChestSlots && stealing; i++) {
                if (chestScreen.getScreenHandler().slots.get(i).inventory != playerInventory) {
                    Chat.sendChatMessage("Stealing item from slot " + i);
                    client.interactionManager.clickSlot(chestScreen.getScreenHandler().syncId, i, 0, SlotActionType.QUICK_MOVE, client.player);
                }
            }
        }
    }
}