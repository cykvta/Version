package cykuta.etheriacore.utils;

import cykuta.etheriacore.EtheriaCore;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class ConfigManager {
    private final EtheriaCore plugin;
    public String cfgRoute;
    final private FileConfiguration cfg;
    final private String path = "config.";

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

    public long secondToTicks(int sec){
        return sec * 20L;
    };

    public String getVersionUrl(){
        return plugin.getConfig().getString("version_url");
    }

    public String getString(String new_path){
        return cfg.getString(path + new_path);
    }

    public int getInt(String new_path){
        return cfg.getInt(path + new_path);
    }
}
