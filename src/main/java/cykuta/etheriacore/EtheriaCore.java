package cykuta.etheriacore;

import cykuta.etheriacore.commands.CommandRegister;
import cykuta.etheriacore.database.Conn;
import cykuta.etheriacore.events.EventRegister;
import cykuta.etheriacore.files.config.ConfigManager;
import cykuta.etheriacore.files.lang.LangManager;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.plugin.java.JavaPlugin;

public final class EtheriaCore extends JavaPlugin {
    public static ConfigManager cfg;
    public static LangManager lang;
    public static Conn conn = null;

    @Override
    public void onEnable() {
        // Load config lang and db
        loadFiles();

        // Event register
        EventRegister events = new EventRegister(getServer().getPluginManager(), this);
        events.registerEvents();

        // Command register
        CommandRegister cmd = new CommandRegister(this);
        cmd.registerCommands();
    }

    public void loadFiles() {
        try {
            cfg = new ConfigManager(this);
            lang = new LangManager(this);
            conn = new Conn(); // Connect to database


        } catch (Exception e){
            Chat.consoleMsg("&4ERROR ON FILES: &e" + e.getMessage());
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    public static ConfigManager getConfigManager(){
        return cfg;
    }

    public static LangManager getLangManager(){
        return lang;
    }
}
