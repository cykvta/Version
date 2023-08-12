package cykuta.etheriacore.events.listeners;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.files.config.Config;
import cykuta.etheriacore.events.Event;
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
        e.setJoinMessage(msg.replaceAll("%player%", player.getName()));
    }

    @EventHandler
    public void playerLeave(PlayerQuitEvent e){
        String msg = Config.QUIT_MSG.getString();
        if (msg.equalsIgnoreCase("none")) return;
        Player player = e.getPlayer();
        e.setQuitMessage(msg.replaceAll("%player%", player.getName()));
    }
}
