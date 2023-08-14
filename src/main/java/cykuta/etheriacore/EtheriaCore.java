package cykuta.etheriacore;

import cykuta.etheriacore.database.Conn;
import cykuta.etheriacore.files.config.ConfigFileManager;
import cykuta.etheriacore.files.lang.LangFileManager;
import cykuta.etheriacore.modules.ModuleManager;
import cykuta.etheriacore.modules.chat.ChatModule;
import cykuta.etheriacore.modules.home.HomeModule;
import cykuta.etheriacore.modules.shortcuts.ShortcutsModule;
import cykuta.etheriacore.modules.sleep.SleepModule;
import cykuta.etheriacore.modules.tpa.TpaModule;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.plugin.java.JavaPlugin;

public final class EtheriaCore extends JavaPlugin {
    private static ConfigFileManager cfg;
    private static LangFileManager lang;
    private static Conn conn = null;
    private static EtheriaCore plugin;
    private ModuleManager moduleManager;

    @Override
    public void onEnable() {
        // Set instance
        plugin = this;

        // Load config lang and db
        loadFiles();

        // Load module manager
        moduleManager = new ModuleManager();

        // Register modules
        registerModules();

        // Load modules
        moduleManager.loadModules();
    }

    public void registerModules() {
        moduleManager.registerModule(new HomeModule());
        moduleManager.registerModule(new ShortcutsModule());
        moduleManager.registerModule(new TpaModule());
        moduleManager.registerModule(new ChatModule());
        moduleManager.registerModule(new SleepModule());
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
