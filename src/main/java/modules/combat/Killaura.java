package modules.combat;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

public class Killaura {
    private static long lastAttackTime = 0;
    private static final long ATTACK_DELAY = 1000;

    public static void toggle(boolean state) {
        if (state) {
            MinecraftClient client = MinecraftClient.getInstance();
            PlayerEntity player = client.player;
            Entity closestEntity = null;
            double closestDistance = Double.MAX_VALUE;

            for (Entity entity : client.world.getEntities()) {
                if (entity.equals(player) || !(entity instanceof LivingEntity) || !((LivingEntity) entity).isAlive()) {
                    continue;
                }

                double distance = player.getPos().distanceTo(entity.getPos());
                if (distance < closestDistance) {
                    closestEntity = entity;
                    closestDistance = distance;
                }
            }

            long currentTime = System.currentTimeMillis();
            if (closestEntity != null && closestDistance <= 5 && currentTime - lastAttackTime >= ATTACK_DELAY) {
                player.swingHand(Hand.MAIN_HAND);
                client.interactionManager.attackEntity(player, closestEntity);
                lastAttackTime = currentTime;
            }
        }
    }
}