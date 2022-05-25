package cykuta.etheriacore.commands.tpa;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.commands.tpa.task.TpaTimer;
import cykuta.etheriacore.config.Config;
import cykuta.etheriacore.config.ConfigManager;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class TpaRequest {
    private static final Map<Player, Player> tpaMap = new HashMap<Player, Player>();

    public static void newRequest(EtheriaCore plugin, Player sender, Player target){
        tpaMap.put(target, sender);
        int time = Config.TELEPORT_EXPIRE.getInt();
        new TpaTimer(plugin, sender, target).runTaskLaterAsynchronously(plugin, ConfigManager.secondToTicks(time));
    }

    public static void removeRequest(Player target){
        tpaMap.remove(target);
    }

    public static boolean hasRequest(Player target){
        return tpaMap.containsKey(target);
    }

    public static Player fetchPlayer(Player player){
        return tpaMap.get(player);
    }
}
