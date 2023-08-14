package cykuta.etheriacore.modules.tpa.utils;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.files.config.Config;
import cykuta.etheriacore.utils.CommandUtils;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class TpaRequest {
    private static final Map<Player, Player> tpaMap = new HashMap<Player, Player>();

    public static void newRequest(Player sender, Player target){
        tpaMap.put(target, sender);
        int time = Config.TELEPORT_EXPIRE.getInt();
        new TpaTimer(sender, target).runTaskLaterAsynchronously(EtheriaCore.getPlugin(), CommandUtils.toTicks(time));
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
