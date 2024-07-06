package be.raft.crafty.plugin;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class CraftyTestPlugin extends JavaPlugin implements Listener {
    public static Logger LOGGER;

    @Override
    public void onEnable() {
        LOGGER = getLogger();

        LOGGER.info("Test Plugin Loaded!");

        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().getInventory().addItem(CraftyItems.MULTILINE_LORE_ITEM);
        event.getPlayer().getInventory().addItem(CraftyItems.MY_CUSTOM_ITEM);
        event.getPlayer().getInventory().addItem(CraftyItems.POTION_ITEM);
    }
}
