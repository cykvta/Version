package cykuta.etheriacore.commands.tpa;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Tpdeny implements CommandExecutor {
    private final EtheriaCore plugin;
    private final String usage = "/tpdeny";

    public Tpdeny(EtheriaCore plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            Chat.consoleError(plugin.error_prefix + plugin.lang.getString("error-player-command"));
            return false;
        }
        Player player = (Player) sender;
        if (!TpaRequest.hasRequest(player)){
            Chat.consoleError(plugin.error_prefix + plugin.lang.getString("error-no-request"));
            return false;
        }

        Player tpSender = TpaRequest.fetchPlayer(player);
        TpaRequest.removeRequest(player);
        Chat.playerMsg(player, plugin.lang.getString("teleport-reject").replaceAll("%player%", player.getName()));
        Chat.playerMsg(player, plugin.lang.getString("teleport-rejected").replaceAll("%player%", tpSender.getName()));

        return false;
    }
}
