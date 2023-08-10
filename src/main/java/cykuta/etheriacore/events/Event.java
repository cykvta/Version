package cykuta.etheriacore.events;

import cykuta.etheriacore.EtheriaCore;
import org.bukkit.event.Listener;

public class Event implements Listener {
    protected EtheriaCore plugin;

    public Event(EtheriaCore plugin) {
        this.plugin = plugin;
    }

    public EtheriaCore getPlugin() {
        return this.plugin;
    }
}
