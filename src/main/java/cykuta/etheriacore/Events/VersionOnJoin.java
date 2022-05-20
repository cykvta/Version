package cykuta.etheriacore.Events;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.Utils.Chat;
import cykuta.etheriacore.Utils.VersionChecker;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class VersionOnJoin implements Listener {
    public EtheriaCore plugin;

    public VersionOnJoin(EtheriaCore plugin) {
        this.plugin = plugin;
    };

    //Evento cuando entra un op le avisa de la update
    @EventHandler
    public void checkVersionOnJoin(PlayerJoinEvent e){
        if (e.getPlayer().isOp() && VersionChecker.oldVersion){
            e.getPlayer().sendMessage(Chat.color("&6[Etheria Core] &aNueva version del plugin disponible"));
        }
    }
}
