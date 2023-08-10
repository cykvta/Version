package cykuta.etheriacore;

import cykuta.etheriacore.commands.CommandRegister;
import cykuta.etheriacore.database.Conn;
import cykuta.etheriacore.events.EventRegister;
import cykuta.etheriacore.config.ConfigManager;
import cykuta.etheriacore.lang.LangError;
import cykuta.etheriacore.utils.Chat;
import cykuta.etheriacore.utils.VersionChecker;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class EtheriaCore extends JavaPlugin {
    public VersionChecker version = new VersionChecker(this);
    public ConfigManager cfg = new ConfigManager(this);
    public static Conn conn = null;

    @Override
    public void onEnable() {
        if (version.checkUpdates(this.getDescription().getVersion())){
            version.sendConsoleMessage();
            VersionChecker.oldVersion = true;
        }

        EventRegister events = new EventRegister(getServer().getPluginManager(), this);
        events.registerEvents(); //Registro de eventos

        CommandRegister cmd = new CommandRegister(this);

        cmd.registerCommands(); //Registro de comandos
        cfg.registerConfig(); //Guarda la config por defecto

        try {
            conn = new Conn(); // Conecta la db
        }catch (SQLException e){
            Chat.consoleMsg(LangError.DATABASE.value + e.getMessage());
        }
    }
}
