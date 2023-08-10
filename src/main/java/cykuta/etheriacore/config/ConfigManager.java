package cykuta.etheriacore.config;

import cykuta.etheriacore.EtheriaCore;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class ConfigManager {
    private FileConfiguration config;

    public ConfigManager(EtheriaCore plugin) throws IOException, InvalidConfigurationException {
        registerConfig(plugin);
    }

    public void registerConfig(EtheriaCore plugin) throws IOException, InvalidConfigurationException {
        File file = new File(plugin.getDataFolder(), "config.yml"); // Create File object
        if (!file.exists()) plugin.saveResource("config.yml", false);

        config = new YamlConfiguration(); // Create YamlConfiguration
        config.load(file);
    }

    public static long secondToTicks(int sec){
        return sec * 20L;
    };

    // Getters
    public String getVersionUrl(){
        return config.getString("version_url");
    }

    public String getString(String path){
        return config.getString(path);
    }

    public int getInt(String path){
        return config.getInt(path);
    }
    public boolean getBoolean(String path){
        return config.getBoolean(path);
    }
}
