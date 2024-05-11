package modules.misc;

public class ChestStealer {
    public static void toggle(boolean state) {
        if (state) {
            System.out.println("Stealing from chest...");
        } else {
            System.out.println("Not stealing from chest...");
        }
    }
}
