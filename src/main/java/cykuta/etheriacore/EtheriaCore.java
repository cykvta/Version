package cykuta.etheriacore;

import cykuta.etheriacore.commands.CommandRegister;
import cykuta.etheriacore.events.EventRegister;
import cykuta.etheriacore.utils.ConfigManager;
import cykuta.etheriacore.utils.VersionChecker;
import org.bukkit.plugin.java.JavaPlugin;

public final class EtheriaCore extends JavaPlugin {
    ConfigManager cfg = new ConfigManager(this);
    VersionChecker version = new VersionChecker(this);

    @Override
    public void onEnable() {
        if (version.checkUpdates(this.getDescription().getVersion())){
            VersionChecker.sendConsoleMessage();
            VersionChecker.oldVersion = true;
        }

        EventRegister events = new EventRegister(getServer().getPluginManager(), this);
        events.registerEvents(); //Registro de eventos

        CommandRegister cmd = new CommandRegister(this);
        cmd.registerCommands(); //Registro de comandos

        cfg.registerConfig(); //Guarda la config por defecto
    }
}
