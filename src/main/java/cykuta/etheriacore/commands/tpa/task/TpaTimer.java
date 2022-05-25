package cykuta.etheriacore.commands.tpa.task;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.lang.LangSuccess;
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
            Chat.playerMsg(sender, LangSuccess.TELEPORT_EXPIRED.value);
        }
    }
}
