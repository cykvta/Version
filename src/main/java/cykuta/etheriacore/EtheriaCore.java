package cykuta.etheriacore;

import cykuta.etheriacore.commands.CommandRegister;
import cykuta.etheriacore.database.Conn;
import cykuta.etheriacore.events.EventRegister;
import cykuta.etheriacore.files.config.ConfigFileManager;
import cykuta.etheriacore.files.lang.LangFileManager;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.plugin.java.JavaPlugin;

public final class EtheriaCore extends JavaPlugin {
    private static ConfigFileManager cfg;
    private static LangFileManager lang;
    private static Conn conn = null;
    private static EtheriaCore plugin;

    @Override
    public void onEnable() {
        // Set instance
        plugin = this;

        // Load config lang and db
        loadFiles();

        // Event register
        EventRegister.registerEvents();

        // Command register
        CommandRegister.registerCommands();
    }

    public void loadFiles() {
        try {
            cfg = new ConfigFileManager();
            lang = new LangFileManager();
            conn = new Conn(); // Connect to database
        } catch (Exception e){
            Chat.consoleMsg("&4ERROR ON FILES: &e" + e.getMessage());
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    public static EtheriaCore getPlugin(){
        return plugin;
    }

    public static ConfigFileManager getConfigManager(){
        return cfg;
    }

    public static LangFileManager getLangManager(){
        return lang;
    }

    public static Conn getConn(){
        return conn;
    }
}
