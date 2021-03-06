package xyz.quosty.world.runnable;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import xyz.quosty.world.QHXWorld;
import xyz.quosty.world.util.ChatUtil;

public class WorldOptimizeRunnable implements Runnable
{
    public WorldOptimizeRunnable(QHXWorld plugin) {
        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, this, 20L, 1200L);
    }

    @Override
    public void run() {

        int entities = 0;
        int itemAmount = 0;

        for (World world : Bukkit.getWorlds()) {

            for (LivingEntity livingEntity : world.getLivingEntities()) {

                if (livingEntity instanceof Player) {
                    continue;
                }

                livingEntity.remove();
                ++entities;
            }
            for (Entity entity : world.getEntities()) {

                if (entity instanceof Player) {

                    continue;
                }

                entity.remove();

                if (entity instanceof Item) {

                    final Item itemStack = (Item)entity;

                    itemAmount += itemStack.getItemStack().getAmount();

                }

                else {

                    ++entities;

                }
            }

            world.setStorm(false);

            world.setTime(7000L);
        }
        Bukkit.broadcastMessage(ChatUtil.colored("&7Usunieto: &b" + (entities + itemAmount) + " &7smieci."));
    }
}
