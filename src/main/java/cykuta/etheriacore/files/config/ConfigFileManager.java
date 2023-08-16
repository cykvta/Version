package cykuta.etheriacore.files.config;

import cykuta.etheriacore.EtheriaCore;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConfigFileManager {
    private FileConfiguration config;
    private File file;

    public ConfigFileManager() throws IOException, InvalidConfigurationException {
        registerConfig();
    }

    public void registerConfig() throws IOException, InvalidConfigurationException {
        // Get plugin instance
        EtheriaCore plugin = EtheriaCore.getPlugin();
        this.file = new File(plugin.getDataFolder(), "config.yml"); // Create File object
        if (!this.file.exists()) plugin.saveResource("config.yml", false);

        config = new YamlConfiguration(); // Create YamlConfiguration
        config.load(this.file);
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
    public List<String> getStringList(String path){
        return config.getStringList(path);
    }

    public void set(String path, Object value){
        config.set(path, value);

        // Save config
        try {
            config.save(this.file);
        } catch (IOException e) {
            throw new RuntimeException("Unable to save config file", e);
        }
    }

    public void reloadConfig() {
        try {
            config.load(this.file);
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException("Unable to reload config file", e);
        }
    }
}
