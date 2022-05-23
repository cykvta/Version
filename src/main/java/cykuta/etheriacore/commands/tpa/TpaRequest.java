package cykuta.etheriacore.commands.tpa;

import cykuta.etheriacore.utils.Chat;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class TpaRequest {
    private static Map<Player, Player> tpaMap = new HashMap<Player, Player>();

    public static void newRequest(Player sender, Player target){
        tpaMap.put(target, sender);
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
