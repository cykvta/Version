package cykuta.etheriacore.utils;

import cykuta.etheriacore.EtheriaCore;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandUtils {
    public static boolean isPlayer(EtheriaCore plugin, CommandSender sender){
        if(!(sender instanceof Player)){
            Chat.consoleMsg(plugin.error_prefix + plugin.lang.getString("error-player-command"));
            return false;
        }
        return true;
    }
}
