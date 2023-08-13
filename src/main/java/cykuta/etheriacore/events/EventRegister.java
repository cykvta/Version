package cykuta.etheriacore.events;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.events.listeners.ChatFormatter;
import cykuta.etheriacore.events.listeners.JoinAnnounce;
import cykuta.etheriacore.events.listeners.PlayerSleep;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

public enum EventRegister {
    JOINANNOUNCE(new JoinAnnounce()),
    PLAYERSLEEP(new PlayerSleep()),
    CHATFORMATTER(new ChatFormatter());

    private final Listener listener;

    EventRegister(Listener listener) {
        this.listener = listener;
    }

    private void register() {
        EtheriaCore plugin = EtheriaCore.getPlugin();
        PluginManager pluginManager  = plugin.getServer().getPluginManager();

        // Register events
        pluginManager.registerEvents(listener, plugin);
    }

    public static void registerEvents(){
        EventRegister[] events = EventRegister.values();

        // Register all events
        for (EventRegister event : events) {
            event.register();
        }
    }
}
