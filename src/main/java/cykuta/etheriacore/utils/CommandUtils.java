package cykuta.etheriacore.utils;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.lang.LangError;
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

    public static boolean isDatabaseEnabled(Player player){
        if(EtheriaCore.conn == null){
            Chat.playerMsg(player, LangError.DATABASE_DISABLED.value);
            return false;
        }
        return true;
    }
}
