package cykuta.etheriacore.commands.tpa;

import cykuta.etheriacore.commands.tpa.task.TpaExpired;
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
    public Tpa(EtheriaCore plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            Chat.consoleError("Este comando solo funciona en jugadores.");
            return false;
        }
        Player player = (Player) sender;

        if(args.length != 1){
            Chat.playerError(player, "Error de sintaxis, usa: /tpa <player>.");
            return false;
        }
        Player target = Bukkit.getPlayer(args[0]);

        if (target == null){
            Chat.playerError(player, "Este jugador no esta conectado.");
            return false;
        }

        if (target == player){
            Chat.playerError(player, "No puedes te puedes enviar una peticion de teletransporte a ti mismo.");
            return false;
        }

        TpaRequest.newRequest(player, target);
        new TpaExpired(player, target).runTaskLaterAsynchronously(plugin,120L);
        return true;
    }
}
