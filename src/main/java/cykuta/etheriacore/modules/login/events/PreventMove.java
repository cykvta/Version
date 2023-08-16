package cykuta.etheriacore.modules.login.events;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.files.config.Config;
import cykuta.etheriacore.files.lang.Lang;
import cykuta.etheriacore.modules.login.utils.Session;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.*;

import java.util.List;

public class PreventMove implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Session session = Session.getSession(player);

        // Prevent player move if not logged in
        if (session == null || !session.isAutorized()) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Session session = Session.getSession(player);

        // Prevent player interact if not logged in
        if (session == null || !session.isAutorized()) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        Session session = Session.getSession(player);

        // Prevent player drop item if not logged in
        if (session == null || !session.isAutorized()) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) return;

        Player player = (Player) event.getEntity();
        Session session = Session.getSession(player);

        // Prevent player damage if not logged in
        if (session == null || !session.isAutorized()) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Session session = Session.getSession(player);

        // Prevent player interact if not logged in
        if (session == null || !session.isAutorized()) {
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();

        // Check if command is in command whitelist
        List<String> commands = Config.ALLOWED_CMDS.getStringList();

        // Get command without slash
        String command = event.getMessage().split(" ")[0];
        command = command.substring(1);

        // Prevent player command if not in whitelist
        if (commands.contains(command)) return;

        // Prevent player command if not logged in
        Session session = Session.getSession(player);
        if (session == null || !session.isAutorized()) {
            Chat.reply(player, Lang.COMMAND_ON_AUTH.get());
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(PlayerChatEvent event) {
        Player player = event.getPlayer();
        Session session = Session.getSession(player);

        // Prevent player chat if not logged in
        if (session == null || !session.isAutorized()) {
            event.setCancelled(true);
        }
    }
}
