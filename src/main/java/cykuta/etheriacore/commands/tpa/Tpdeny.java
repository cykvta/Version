package cykuta.etheriacore.commands.tpa;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.files.lang.LangError;
import cykuta.etheriacore.files.lang.LangSuccess;
import cykuta.etheriacore.utils.Chat;
import cykuta.etheriacore.utils.CommandUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Tpdeny implements CommandExecutor {
    private final EtheriaCore plugin;

    public Tpdeny(EtheriaCore plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!CommandUtils.isPlayer(sender)) return false;

        Player player = (Player) sender;
        if (!TpaRequest.hasRequest(player)){
            Chat.playerMsg(player, LangError.TELEPORT_NO_REQUEST.value);
            return false;
        }

        Player tpSender = TpaRequest.fetchPlayer(player);
        TpaRequest.removeRequest(player);
        Chat.playerMsg(player, LangSuccess.TELEPORT_REJECT.value.replaceAll("%player%", tpSender.getName()));
        Chat.playerMsg(tpSender, LangSuccess.TELEPORT_REJECTED.value.replaceAll("%player%", player.getName()));
        return false;
    }
}
