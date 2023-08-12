package cykuta.etheriacore.events;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.events.listeners.ChatFormatter;
import cykuta.etheriacore.events.listeners.JoinAnnounce;
import cykuta.etheriacore.events.listeners.PlayerSleep;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

public class EventRegister {
    public static void registerEvents(){
        EtheriaCore plugin = EtheriaCore.getPlugin();
        PluginManager pluginManager  = plugin.getServer().getPluginManager();

        // Register events
        pluginManager.registerEvents(new JoinAnnounce(), plugin);
        pluginManager.registerEvents(new PlayerSleep(), plugin);
        pluginManager.registerEvents(new ChatFormatter(), plugin);
    }
}
