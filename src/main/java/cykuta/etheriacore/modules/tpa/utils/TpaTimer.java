package cykuta.etheriacore.modules.tpa.utils;

import cykuta.etheriacore.files.lang.Lang;
import cykuta.etheriacore.utils.Chat;
import cykuta.etheriacore.modules.tpa.utils.TpaRequest;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TpaTimer extends BukkitRunnable {
    private final Player sender;
    private final Player target;

    public TpaTimer(Player sender, Player target){
        this.sender = sender;
        this.target = target;
    }

    @Override
    public void run() {
        if(TpaRequest.hasRequest(target)){
            TpaRequest.removeRequest(target);
            Chat.reply(sender, Lang.TELEPORT_EXPIRED.get().replaceAll("%player%", target.getName()));
        }
    }
}
