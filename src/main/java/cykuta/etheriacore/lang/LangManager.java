package cykuta.etheriacore.lang;

import cykuta.etheriacore.EtheriaCore;
import org.bukkit.configuration.file.FileConfiguration;

public class LangManager {
    final private EtheriaCore plugin;
    final private FileConfiguration cfg;
    final private String path = "lang.";

    public LangManager(EtheriaCore plugin){
        this.plugin = plugin;
        this.cfg = plugin.getConfig();
    }

    public String getString(String path){
        return cfg.getString(path + path);
    }
}
