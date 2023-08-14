package cykuta.etheriacore.commands.home;

import cykuta.etheriacore.commands.CoreCommand;
import cykuta.etheriacore.files.lang.Lang;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class SetHome extends CoreCommand {

    public SetHome() {
        setAllowConsole(false);
    }

    @Override
    public boolean exec(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        try {
            PlayerHome home = new PlayerHome(player);
            if (home.hasHome()) {
                Chat.reply(player, Lang.MAX_HOMES.get());
                return false;
            }
            home.setHome(player.getLocation());
            Chat.reply(player, Lang.NEW_HOME.get());
            return true;

        } catch (SQLException e) {
            Chat.reply(player, Lang.DATABASE.get() + e);
        }

        return false;
    }
}
