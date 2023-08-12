package cykuta.etheriacore.events.listeners;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.events.Event;
import cykuta.etheriacore.files.config.Config;
import cykuta.etheriacore.files.lang.LangSuccess;
import cykuta.etheriacore.utils.Chat;
import io.papermc.paper.event.player.PlayerDeepSleepEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import java.util.ArrayList;

public class PlayerSleep extends Event {
    private final ArrayList<Player> sleepingPlayers = new ArrayList<>();

    public PlayerSleep(EtheriaCore plugin) {
        super(plugin);
    }

    @EventHandler
    public void onPlayerSleep(PlayerDeepSleepEvent event) {
        Player player = event.getPlayer();

        // Verify if player is in sleeping list
        if (!sleepingPlayers.contains(player)) sleepingPlayers.add(player);

        // calculate %
        int playersInWorld = player.getWorld().getPlayers().size();
        int sleepingPlayersInWorld = sleepingPlayers.size();
        int percent = Config.PERCENTAGE_TO_SKIP_NIGHT.getInt();
        int neededPlayers = (int) Math.ceil(playersInWorld * percent / 100.0);

        // Format message
        String msg = LangSuccess.PLAYER_ENTER_BED.value.replace("%player%", player.getName())
                .replace("%sleeping_players%", String.valueOf(sleepingPlayersInWorld))
                .replace("%needed_players%", String.valueOf(neededPlayers));

        // Send message to all players in the world
        Chat.sendGlobalMessage(msg);

        // Verify if % of sleeping players is greater than % of needed players to skip night
        if (sleepingPlayersInWorld >= neededPlayers) {

            // Skip night
            player.getWorld().setTime(0);

            // Clear sleeping players list
            sleepingPlayers.clear();

            // Send message to all players in the world
            Chat.sendGlobalMessage(LangSuccess.NIGHT_SKIPPED.value);
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();

        // Verify if player is in sleeping list
        if (!sleepingPlayers.contains(player)) return;

        // Remove player from sleeping list
        sleepingPlayers.remove(player);

        // calculate %
        int playersInWorld = player.getWorld().getPlayers().size();
        int sleepingPlayersInWorld = sleepingPlayers.size();
        int percent = Config.PERCENTAGE_TO_SKIP_NIGHT.getInt();
        int neededPlayers = (int) Math.ceil(playersInWorld * percent / 100.0);

        // Format message
        String msg = LangSuccess.PLAYER_LEAVE_BED.value.replace("%player%", player.getName())
                .replace("%sleeping_players%", String.valueOf(sleepingPlayersInWorld))
                .replace("%needed_players%", String.valueOf(neededPlayers));

        // Send message to all players in the world
        Chat.sendGlobalMessage(msg);
    }
}
