package cykuta.etheriacore.files.config;

import cykuta.etheriacore.EtheriaCore;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class ConfigManager {
    private FileConfiguration config;

    public ConfigManager() throws IOException, InvalidConfigurationException {
        registerConfig();
    }

    public void registerConfig() throws IOException, InvalidConfigurationException {
        // Get plugin instance
        EtheriaCore plugin = EtheriaCore.getPlugin();
        File file = new File(plugin.getDataFolder(), "config.yml"); // Create File object
        if (!file.exists()) plugin.saveResource("config.yml", false);

        config = new YamlConfiguration(); // Create YamlConfiguration
        config.load(file);
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
