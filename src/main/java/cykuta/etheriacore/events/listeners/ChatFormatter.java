package cykuta.etheriacore.events.listeners;

import cykuta.etheriacore.files.config.Config;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormatter implements Listener {

    /* TODO:
        * 1. Add luckperms support
     */
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        Player player = event.getPlayer();

        String format = Config.CHAT_FORMAT.getString()
                .replace("%player%", player.getName())
                .replace("%message%", message);

        format = Chat.color(format);
        event.setFormat(format);
    }
}
