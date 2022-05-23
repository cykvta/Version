package cykuta.etheriacore.commands.tpa.task;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.utils.Chat;
import cykuta.etheriacore.commands.tpa.TpaRequest;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TpaTimer extends BukkitRunnable {
    private final Player sender;
    private final Player target;
    private final EtheriaCore plugin;

    public TpaTimer(EtheriaCore plugin, Player sender, Player target){
        this.sender = sender;
        this.target = target;
        this.plugin = plugin;
    }

    @Override
    public void run() {
        if(TpaRequest.hasRequest(target)){
            TpaRequest.removeRequest(target);
            Chat.playerMsg(sender, plugin.main_prefix +"La peticion de teletransporte a &6"+ target.getName() +" &7expiro.");
            Chat.playerMsg(target, plugin.main_prefix +"La peticion para teletransportarse de &6"+ sender.getName() +" &7expiro.");
        }
    }
}
