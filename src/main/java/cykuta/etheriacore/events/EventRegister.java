package cykuta.etheriacore.events;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.events.listeners.JoinAnnounce;
import cykuta.etheriacore.events.listeners.PlayerSleep;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

public class EventRegister {

    private final PluginManager pluginManager;
    private final EtheriaCore plugin;
    public EventRegister(final PluginManager pluginManager, EtheriaCore plugin){
        this.pluginManager = pluginManager;
        this.plugin = plugin;
    }

    // Register events
    public void registerEvents(){
        pluginManager.registerEvents(new JoinAnnounce(plugin), plugin);
        pluginManager.registerEvents(new PlayerSleep(plugin), plugin);
    }
}
