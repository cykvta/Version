package cykuta.etheriacore.commands.tpa;

import cykuta.etheriacore.commands.tpa.task.TpaTimer;
import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Tpa implements CommandExecutor {
    private final EtheriaCore plugin;
    private final String usage = "/tpa <player>";

    public Tpa(EtheriaCore plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            Chat.consoleError(plugin.error_prefix +
                    plugin.lang.getString("error-player-command"));
            return false;
        }
        Player player = (Player) sender;

        if(args.length != 1){
            Chat.playerMsg(player, plugin.error_prefix +
                    plugin.lang.getString("error-usage").format(usage));
            return false;
        }
        Player target = Bukkit.getPlayer(args[0]);

        if (target == null){
            Chat.playerMsg(player, plugin.error_prefix +
                    plugin.lang.getString("error-no-player"));
            return false;
        }

        if (target == player){
            Chat.playerMsg(player, plugin.error_prefix +
                    plugin.lang.getString("error-auto-target"));
            return false;
        }

        TpaRequest.newRequest(player, target);
        Chat.playerMsg(player, "Realizaste una peticion de teletrasporte a &6" + target.getName() + "&7.");
        Chat.playerMsg(target, "El usuario &6" + sender.getName() + " &7quiere teletrasnportarse contigo.");
        Chat.playerMsg(target, "&7Para responder usa: &a/aceptar &7o &c/denegar");
        new TpaTimer(player, target).runTaskLaterAsynchronously(plugin,120L);
        return true;
    }
}
