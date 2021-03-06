package xyz.quosty.world;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.quosty.world.runnable.WorldOptimizeRunnable;

public class QHXWorld extends JavaPlugin
{

    @Override
    public void onEnable() {

        new WorldOptimizeRunnable(this);

        super.onEnable();
    }
}
