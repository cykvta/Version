package cykuta.etheriacore.commands.home;

import cykuta.etheriacore.files.lang.LangError;
import cykuta.etheriacore.files.lang.LangSuccess;
import cykuta.etheriacore.utils.Chat;
import cykuta.etheriacore.utils.CommandUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;

public class DelHome implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!CommandUtils.isPlayer(sender)) return false;
        Player player = (Player) sender;

        if(!CommandUtils.isDatabaseEnabled(player)) return false;

        try {
            PlayerHome home = new PlayerHome(player);
            if (!home.hasHome()) {
                Chat.playerMsg(player, LangError.NO_HOMES.value);
                return false;
            }
            home.removeHome(player);
            Chat.playerMsg(player, LangSuccess.REMOVE_HOME.value);
            return true;

        } catch (SQLException e) {
            Chat.playerMsg(player, LangError.DATABASE.value + e);
        }

        return false;
    }
}
