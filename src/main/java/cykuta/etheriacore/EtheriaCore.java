package cykuta.etheriacore;

import cykuta.etheriacore.Events.EventRegister;
import cykuta.etheriacore.Utils.ConfigManager;
import cykuta.etheriacore.Utils.VersionChecker;
import org.bukkit.plugin.java.JavaPlugin;

public final class EtheriaCore extends JavaPlugin {
    ConfigManager cfg = new ConfigManager(this);

    @Override
    public void onEnable() {
        if (VersionChecker.checkUpdates(this.getDescription().getVersion())){
            VersionChecker.sendConsoleMessage();
            VersionChecker.oldVersion = true;
        }

        EventRegister events = new EventRegister(getServer().getPluginManager(), this);
        events.registerEvents(); //Registro de eventos
        cfg.registerConfig(); //Guarda la config por defecto
    }
}
