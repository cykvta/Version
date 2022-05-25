package cykuta.etheriacore.events;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.config.Config;
import cykuta.etheriacore.utils.Chat;
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
