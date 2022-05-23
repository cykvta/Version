package cykuta.etheriacore.commands.tpa;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Tpaccept implements CommandExecutor {
    private final EtheriaCore plugin;
    private final String usage = "/tpaccept";

    public Tpaccept(EtheriaCore plugin){
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
        tpSender.teleport(player.getLocation());
        Chat.playerMsg(player, plugin.main_prefix +
                plugin.lang.getString("teleport-accept").replaceAll("%player%", player.getName()));
        Chat.playerMsg(tpSender, plugin.main_prefix +
                plugin.lang.getString("teleport-accepted").replaceAll("%player%", player.getName()));
        return true;
    }
}
