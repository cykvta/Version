package cykuta.etheriacore.utils;

import cykuta.etheriacore.EtheriaCore;

import java.io.File;
import java.util.List;

public class ConfigManager {
    private final EtheriaCore plugin;
    public String cfgRoute;

    public ConfigManager(final EtheriaCore plugin){
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

    public List<String> getBannedItems(){
        return plugin.getConfig().getStringList("banitem");
    }
}
