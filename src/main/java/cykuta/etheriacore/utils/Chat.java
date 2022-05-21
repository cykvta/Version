package cykuta.etheriacore.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Chat {
    public static String color(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void playerError( Player player, String msg){
        player.sendMessage(Chat.color("&4[Error] &c" + msg));
    }

    public static void playerMsg( Player player, String msg){
        player.sendMessage(Chat.color("&6[Core] &7" + msg));
    }

    public static void consoleError(String msg){
        Bukkit.getConsoleSender().sendMessage(Chat.color("&4[Error] &c" + msg));
    }
}
