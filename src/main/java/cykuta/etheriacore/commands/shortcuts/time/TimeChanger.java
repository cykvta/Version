package cykuta.etheriacore.commands.shortcuts.time;

import cykuta.etheriacore.lang.LangError;
import cykuta.etheriacore.lang.LangSuccess;
import cykuta.etheriacore.utils.Chat;
import cykuta.etheriacore.utils.CommandUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TimeChanger implements CommandExecutor {
    private int time;
    public TimeChanger(int time){
        this.time = time;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!CommandUtils.isPlayer(sender)) {
            try {
                World world = Bukkit.getServer().getWorld(args[1]);
                world.setTime(time);

                Chat.consoleMsg(LangSuccess.TIME_SET.value
                        .replaceAll("%world%", world.getName())
                        .replaceAll("%time%", String.valueOf(time)));
                return true;
            }catch (Exception e){
                Chat.consoleMsg(LangError.USAGE.value.replaceAll("%usage%", command.getUsage()));
                return false;
            }
        }

        Player player = (Player) sender;
        player.getWorld().setTime(time);
        World world = player.getWorld();

        Chat.playerMsg(player, LangSuccess.TIME_SET.value
                .replaceAll("%world%", world.getName())
                .replaceAll("%time%", String.valueOf(time)));
        return true;
    }
}
