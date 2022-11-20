package exgreenblock.exgreenblock;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ExGreenBlock extends JavaPlugin {
    public static ExGreenBlock plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new EventListner(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
