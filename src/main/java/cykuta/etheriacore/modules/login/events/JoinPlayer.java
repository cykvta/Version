package cykuta.etheriacore.modules.login.events;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.files.config.Config;
import cykuta.etheriacore.files.lang.Lang;
import cykuta.etheriacore.modules.login.LoginModule;
import cykuta.etheriacore.modules.login.utils.SessionManager;
import cykuta.etheriacore.modules.login.utils.Timeout;
import cykuta.etheriacore.utils.Chat;
import cykuta.etheriacore.utils.CommandUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinPlayer implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Get SessionManager
        SessionManager sm = LoginModule.getSessionManager();

        if(sm.isRegistered(player)) Chat.reply(player, Lang.LOGIN.get());
        else Chat.reply(player, Lang.REGISTER.get());

        int time = Config.AUTH_TIMEOUT.getInt();
        new Timeout(player).runTaskLater(EtheriaCore.getPlugin(), CommandUtils.toTicks(time));
    }

    @EventHandler
    public static void onLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Timeout.removeTimer(player);
    }
}
