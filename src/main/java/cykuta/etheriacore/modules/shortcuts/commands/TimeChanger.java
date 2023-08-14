package cykuta.etheriacore.modules.shortcuts.commands;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.CoreCommand;
import cykuta.etheriacore.files.lang.Lang;
import cykuta.etheriacore.utils.Chat;
import cykuta.etheriacore.utils.TimeLapse;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimeChanger extends CoreCommand {
    private final int time;
    public TimeChanger(int time){
        this.time = time;
        setAllowConsole(false);
    }

    @Override
    public boolean exec(CommandSender sender, String[] args) {
        if (TimeLapse.isRunning()) {
            Chat.reply(sender, Lang.TIME_SKIP_IN_PROGRESS.get());
            return false;
        }

        Player player = (Player) sender;
        World world = player.getWorld();
        new TimeLapse(world, time).runTaskTimer(EtheriaCore.getPlugin(), 0, 1);

        Chat.reply(player, Lang.TIME_SET.get()
                .replaceAll("%world%", world.getName())
                .replaceAll("%time%", String.valueOf(time)));
        return true;
    }
}
