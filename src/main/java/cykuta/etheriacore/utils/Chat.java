package cykuta.etheriacore.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Chat {
    public static String color(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void reply(CommandSender player, String msg){
        player.sendMessage(Chat.color(msg));
    }

    public static void sendGlobalMessage(String msg){
        for(Player player : Bukkit.getOnlinePlayers()){
            player.sendMessage(Chat.color(msg));
        }
    }

    public static void consoleMsg(String msg){
        Bukkit.getConsoleSender().sendMessage(Chat.color(msg));
    }
}
