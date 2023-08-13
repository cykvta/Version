package cykuta.etheriacore.commands.shortcuts.time;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.files.lang.LangError;
import cykuta.etheriacore.files.lang.LangSuccess;
import cykuta.etheriacore.utils.Chat;
import cykuta.etheriacore.utils.CommandUtils;
import cykuta.etheriacore.utils.TimeLapse;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TimeChanger implements CommandExecutor {
    private final int time;
    public TimeChanger(int time){
        this.time = time;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!CommandUtils.isPlayer(sender)) return false;
        if (TimeLapse.isRunning()) {
            Chat.playerMsg((Player) sender, LangError.TIME_SKIP_IN_PROGRESS.value);
            return false;
        }

        Player player = (Player) sender;
        World world = player.getWorld();
        new TimeLapse(world, time).runTaskTimer(EtheriaCore.getPlugin(), 0, 1);

        Chat.playerMsg(player, LangSuccess.TIME_SET.value
                .replaceAll("%world%", world.getName())
                .replaceAll("%time%", String.valueOf(time)));
        return true;
    }
}
