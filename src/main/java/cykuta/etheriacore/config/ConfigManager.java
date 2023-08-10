package cykuta.etheriacore.config;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class ConfigManager {
    private final EtheriaCore plugin;
    public String cfgRoute;
    final private FileConfiguration cfg;
    final static private String path = "config.";

    public ConfigManager(final EtheriaCore plugin){
        this.cfg = plugin.getConfig();
        this.plugin = plugin;
    }

    public void registerConfig() {
        File config = new File(plugin.getDataFolder(), "config.yml");
        cfgRoute = config.getPath();
        if (!config.exists()) {
            plugin.getConfig().options().copyDefaults(true);
            plugin.saveConfig();
        }
    }

    public static long secondToTicks(int sec){
        return sec * 20L;
    };

    public String getVersionUrl(){
        return plugin.getConfig().getString("version_url");
    }

    public static String getString(String new_path){
        String str = JavaPlugin.getProvidingPlugin(EtheriaCore.class).getConfig().getString(path + new_path);
        return Chat.color(str);
    }

    public static String getPureString(String new_path){
        return JavaPlugin.getProvidingPlugin(EtheriaCore.class).getConfig().getString(path + new_path);
    }

    public static int getInt(String new_path){
        return JavaPlugin.getProvidingPlugin(EtheriaCore.class).getConfig().getInt(path + new_path);
    }
    public static boolean getBoolean(String new_path){
        return JavaPlugin.getProvidingPlugin(EtheriaCore.class).getConfig().getBoolean(path + new_path);
    }
}
