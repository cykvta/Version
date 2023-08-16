package cykuta.etheriacore.modules;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.CoreCommand;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

public abstract class CoreModule {
    protected final EtheriaCore plugin = EtheriaCore.getPlugin();
    protected final PluginManager pm = plugin.getServer().getPluginManager();
    protected boolean enabled = true;
    public abstract void registerCommands();
    public abstract void registerEvents();
    public abstract void registerOthers();

    protected void registerCommand(CoreCommand exec, String name, String permission) {
        PluginCommand cmd = plugin.getCommand(name);

        if (cmd == null) {
            Chat.consoleMsg("&cFailed to register command: " + name);
            return;
        }

        cmd.setExecutor(exec);
        exec.setPermission(permission);
    }

    protected void registerEvent(Listener listener) {
        pm.registerEvents(listener, plugin);
    }

    protected boolean isEnabled() {
        return enabled;
    }

    protected void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
