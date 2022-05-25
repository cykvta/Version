package cykuta.etheriacore.lang;

import cykuta.etheriacore.EtheriaCore;
import org.bukkit.plugin.java.JavaPlugin;

public class LangManager {
    public static String getString(String new_path){
        String path = "lang.";
        return JavaPlugin.getProvidingPlugin(EtheriaCore.class).getConfig().getString(path + new_path);
    }
}
