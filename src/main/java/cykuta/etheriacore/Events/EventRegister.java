package cykuta.etheriacore.Events;

import cykuta.etheriacore.EtheriaCore;
import org.bukkit.plugin.PluginManager;

public class EventRegister {

    private final PluginManager pluginManager;
    private final EtheriaCore plugin;
    public EventRegister(final PluginManager pluginManager, EtheriaCore plugin){
        this.pluginManager = pluginManager;
        this.plugin = plugin;
    }

    public void registerEvents(){
        pluginManager.registerEvents(new BlockCraft(plugin), plugin);
    }
}
