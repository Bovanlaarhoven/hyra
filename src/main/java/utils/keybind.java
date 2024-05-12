package utils;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

import java.util.HashMap;
import java.util.Map;

public class keybind {
    private static Map<String, Boolean> toggledStates = new HashMap<>();
    private static Map<String, KeyBinding> keybinds = new HashMap<>();
    private static Map<String, Boolean> wasPressedStates = new HashMap<>();
    private static Map<String, Long> lastToggleTimes = new HashMap<>();

    public static void createKeybind(String name, int key) {
        KeyBinding keybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(name, InputUtil.Type.KEYSYM, key, "Hyra"));
        keybinds.put(name, keybind);
        toggledStates.put(name, false);
        wasPressedStates.put(name, false);
        lastToggleTimes.put(name, System.currentTimeMillis());
    }

    public static boolean isPressed(String name) {
        KeyBinding keybind = keybinds.get(name);
        return keybind != null && keybind.isPressed();
    }

    public static boolean isToggled(String name) {
        KeyBinding keybind = keybinds.get(name);
        Boolean toggled = toggledStates.get(name);
        Boolean wasPressed = wasPressedStates.get(name);
        Long lastToggleTime = lastToggleTimes.get(name);

        if (keybind != null && toggled != null && wasPressed != null && lastToggleTime != null && keybind.isPressed() && !wasPressed) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastToggleTime >= 200) {
                toggled = !toggled;
                toggledStates.put(name, toggled);
                lastToggleTimes.put(name, currentTime);
            }
        }

        return toggled != null && toggled;
    }
}