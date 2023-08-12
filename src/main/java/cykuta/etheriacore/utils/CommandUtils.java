package cykuta.etheriacore.utils;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.files.lang.LangError;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandUtils {
    public static boolean isPlayer(CommandSender sender){
        if(!(sender instanceof Player)){
            Chat.consoleMsg(LangError.PLAYER_COMMAND.value);
            return false;
        }
        return true;
    }

    // Check if database is enabled
    public static boolean isDatabaseEnabled(Player player){
        if(EtheriaCore.conn == null){
            Chat.playerMsg(player, LangError.DATABASE_DISABLED.value);
            return false;
        }
        return true;
    }
}
