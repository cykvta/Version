package cykuta.etheriacore.commands.tpa.task;

import cykuta.etheriacore.utils.Chat;
import cykuta.etheriacore.commands.tpa.TpaRequest;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TpaExpired extends BukkitRunnable {
    private final Player sender;
    private final Player target;

    public TpaExpired (Player sender, Player target){
        this.sender = sender;
        this.target = target;
    }

    @Override
    public void run() {
        if(TpaRequest.hasRequest(target)){
            TpaRequest.removeRequest(target);
            Chat.playerMsg(sender, "La peticion de teletransporte a &6"+ target.getName() +" &7expiro.");
            Chat.playerMsg(target, "La peticion para teletransportarse de &6"+ sender.getName() +" &7expiro.");
        }
    }
}
