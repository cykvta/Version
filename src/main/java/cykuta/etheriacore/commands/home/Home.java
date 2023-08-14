package cykuta.etheriacore.commands.home;

import cykuta.etheriacore.commands.CoreCommand;
import cykuta.etheriacore.files.lang.Lang;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class Home extends CoreCommand {

    public Home(){
        setAllowConsole(false);
    }

    @Override
    public boolean exec(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        try {
            PlayerHome home = new PlayerHome(player);
            if (!home.hasHome()) {
                Chat.reply(player, Lang.NO_HOMES.get());
                return false;
            }
            Location loc = home.getHomeLocation();

            if (loc == null) {
                Chat.reply(player, Lang.HOME_LOCATION.get());
                return false;
            }

            player.teleport(loc);
            Chat.reply(player, Lang.TELEPORT_HOME.get());
            return true;


        } catch (SQLException e) {
            Chat.reply(player, Lang.DATABASE.get() + e);
        }

        return false;
    }
}
