package cykuta.etheriacore.Utils;

import org.bukkit.ChatColor;

public class Chat {
    public static String color(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
