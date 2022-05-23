package cykuta.etheriacore.commands.tpa;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.utils.Chat;
import cykuta.etheriacore.utils.CommandUtils;
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
        if(CommandUtils.isPlayer(plugin, sender)) return false;

        Player player = (Player) sender;
        if (!TpaRequest.hasRequest(player)){
            Chat.consoleMsg(plugin.error_prefix + plugin.lang.getString("error-no-request"));
            return false;
        }

        Player tpSender = TpaRequest.fetchPlayer(player);
        TpaRequest.removeRequest(player);
        Chat.playerMsg(player, plugin.main_prefix +
                plugin.lang.getString("teleport-reject").replaceAll("%player%", player.getName()));
        Chat.playerMsg(tpSender, plugin.main_prefix +
                plugin.lang.getString("teleport-rejected").replaceAll("%player%", tpSender.getName()));

        return false;
    }
}
