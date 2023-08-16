package cykuta.etheriacore.modules.login.utils;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.files.lang.Lang;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class Timeout extends BukkitRunnable {
    private static final Map<Player, Timeout> timeoutMap = new HashMap<>();
    private final Player player;

    public Timeout(Player player) {
        this.player = player;
        timeoutMap.put(player, this);
    }
    @Override
    public void run() {
         // Get player session
        Session session = Session.getSession(player);
        String kickMessage = Lang.TIME_OUT.get();

        if (session == null) {
            player.kickPlayer(kickMessage);
            return;
        }

        if (!session.isAutorized()) {
            player.kickPlayer(kickMessage);
            return;
        }
    }
    public static void removeTimer(Player player) {
        Timeout timeout = timeoutMap.get(player);
        if (timeout == null) return;

        timeout.cancel();
        timeoutMap.remove(player);
    }
}
