package cykuta.etheriacore.modules.chat.events;

import cykuta.etheriacore.files.config.Config;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinAnnounce implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent e){
        String msg = Config.JOIN_MSG.getString();
        if (msg.equalsIgnoreCase("none")) return;
        Player player = e.getPlayer();

        // Format message
        msg = Chat.color(msg);
        msg = msg.replace("%player%", player.getName());

        e.setJoinMessage(msg);
    }

    @EventHandler
    public void playerLeave(PlayerQuitEvent e){
        String msg = Config.QUIT_MSG.getString();
        if (msg.equalsIgnoreCase("none")) return;
        Player player = e.getPlayer();

        // Format message
        msg = Chat.color(msg);
        msg = msg.replace("%player%", player.getName());

        e.setQuitMessage(msg);
    }
}
