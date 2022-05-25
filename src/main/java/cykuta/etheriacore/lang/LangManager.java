package cykuta.etheriacore.lang;

import cykuta.etheriacore.EtheriaCore;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class LangManager {
    final private FileConfiguration cfg;

    public LangManager(EtheriaCore plugin){
        this.cfg = plugin.getConfig();
    }

    public static String getString(String new_path){
        String path = "lang.";
        return JavaPlugin.getProvidingPlugin(EtheriaCore.class).getConfig().getString(path + new_path);
    }
}
