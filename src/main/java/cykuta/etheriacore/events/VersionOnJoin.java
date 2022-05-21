package cykuta.etheriacore.events;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.utils.Chat;
import cykuta.etheriacore.utils.VersionChecker;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class VersionOnJoin implements Listener {
    public EtheriaCore plugin;

    public VersionOnJoin(EtheriaCore plugin) {
        this.plugin = plugin;
    };

    /*
    * Este evento se activa cuando entra un jugador con permiso op
    * y se le envia un mensaje diciendo que hay una actualizacion disponible.
    */
    @EventHandler
    public void checkVersionOnJoin(PlayerJoinEvent e){
        if (e.getPlayer().isOp() && VersionChecker.oldVersion){
            e.getPlayer().sendMessage(Chat.color("&6[Etheria Core] &aNueva version del plugin disponible"));
        }
    }
}
