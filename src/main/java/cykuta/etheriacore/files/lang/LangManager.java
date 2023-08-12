package cykuta.etheriacore.files.lang;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class LangManager {
    private FileConfiguration lang;

    public LangManager() throws IOException, InvalidConfigurationException {
        registerLang();
    }

    public void registerLang() throws IOException, InvalidConfigurationException {
        // Get plugin instance
        EtheriaCore plugin = EtheriaCore.getPlugin();
        File file = new File(plugin.getDataFolder(), "lang.yml"); // Create File object
        if (!file.exists()) plugin.saveResource("lang.yml", false);

        lang = new YamlConfiguration(); // Create YamlConfiguration
        lang.load(file);
    }

    public String getString(String path){
        String str = lang.getString(path);
        return Chat.color(str);
    }
}
