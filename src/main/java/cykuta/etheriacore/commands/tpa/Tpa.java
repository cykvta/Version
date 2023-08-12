package cykuta.etheriacore.commands.tpa;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.files.lang.LangError;
import cykuta.etheriacore.files.lang.LangSuccess;
import cykuta.etheriacore.utils.Chat;
import cykuta.etheriacore.utils.CommandUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Tpa implements CommandExecutor {
    private final EtheriaCore plugin;

    public Tpa(EtheriaCore plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!CommandUtils.isPlayer(sender)) return false;

        Player player = (Player) sender;
        if(args.length != 1){
            Chat.playerMsg(player, LangError.USAGE.value.replaceAll("%usage%" ,command.getUsage()));
            return false;
        }
        Player target = Bukkit.getPlayer(args[0]);

        if (target == null){
            Chat.playerMsg(player, LangError.NO_PLAYER.value);
            return false;
        }

        if (target == player){
            Chat.playerMsg(player, LangError.AUTO_TARGET.value);
            return false;
        }
        TpaRequest.newRequest(plugin, player, target);

        Chat.playerMsg(player, LangSuccess.TELEPORT_SEND.value.replaceAll("%player%", target.getName()));
        Chat.playerMsg(target, LangSuccess.TELEPORT_REQUEST.value.replaceAll("%player%", player.getName()));
        Chat.playerMsg(target, LangSuccess.TELEPORT_ACTIONS.value.replaceAll("%player%", player.getName()));
        return true;
    }
}
