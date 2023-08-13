package cykuta.etheriacore.utils;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.files.lang.LangError;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CommandUtils {
    public static boolean isPlayer(CommandSender sender){
        if(sender instanceof Player) return true;
        Chat.consoleMsg(LangError.PLAYER_COMMAND.value);
        return false;
    }

    public static long toTicks(int sec){
        return sec * 20L;
    };

}
