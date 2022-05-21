package cykuta.etheriacore.commands.tpa;

import cykuta.etheriacore.utils.Chat;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class TpaRequest {
    private static Map<Player, Player> tpaMap = new HashMap<Player, Player>();

    public static void newRequest(Player sender, Player target){
        tpaMap.put(target, sender);
        Chat.playerMsg(sender, "Realizaste una peticion de teletrasporte a &6" + target.getName() + "&7.");

        Chat.playerMsg(target, "El usuario &6" + sender.getName() + " &7quiere teletrasnportarse contigo.");
        Chat.playerMsg(target, "&7Para responder usa: &a/aceptar &7o &c/denegar");
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
