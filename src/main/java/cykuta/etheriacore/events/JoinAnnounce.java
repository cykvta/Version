package cykuta.etheriacore.events;

import cykuta.etheriacore.EtheriaCore;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinAnnounce implements Listener {
    private EtheriaCore plugin;

    public JoinAnnounce(EtheriaCore plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent e){
        String msg = plugin.cfg.getString("join-msg-replace");
        if (msg.equalsIgnoreCase("none")) return;
        Player player = e.getPlayer();
        e.setJoinMessage(msg.replaceAll("%format%", player.getName()));
    }

    @EventHandler
    public void playerLeave(PlayerQuitEvent e){
        String msg = plugin.cfg.getString("quit-msg-replace");
        if (msg.equalsIgnoreCase("none")) return;
        Player player = e.getPlayer();
        e.setQuitMessage(msg.replaceAll("%format%", player.getName()));
    }
}
