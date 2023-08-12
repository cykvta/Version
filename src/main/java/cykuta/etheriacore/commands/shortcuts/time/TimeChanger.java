package cykuta.etheriacore.commands.shortcuts.time;

import cykuta.etheriacore.files.lang.LangSuccess;
import cykuta.etheriacore.utils.Chat;
import cykuta.etheriacore.utils.CommandUtils;
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
        if (!CommandUtils.isPlayer(sender)) return false;
        Player player = (Player) sender;
        World world = player.getWorld();
        world.setTime(time);

        Chat.playerMsg(player, LangSuccess.TIME_SET.value
                .replaceAll("%world%", world.getName())
                .replaceAll("%time%", String.valueOf(time)));
        return true;
    }
}
