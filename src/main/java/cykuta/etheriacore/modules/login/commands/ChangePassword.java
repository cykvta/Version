package cykuta.etheriacore.modules.login.commands;

import cykuta.etheriacore.CoreCommand;
import cykuta.etheriacore.files.config.Config;
import cykuta.etheriacore.files.lang.Lang;
import cykuta.etheriacore.modules.login.LoginModule;
import cykuta.etheriacore.modules.login.utils.Security;
import cykuta.etheriacore.modules.login.utils.Session;
import cykuta.etheriacore.modules.login.utils.SessionManager;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class ChangePassword extends CoreCommand {
    @Override
    public boolean exec(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if (args.length != 2)  {
            Chat.reply(player, Lang.USAGE.get().replace("%usage%", usage));
            return false;
        }

        Session session = Session.getSession(player);

        // Check if player is already logged in
        if (session == null) {
            Chat.reply(player, Lang.NOT_REGISTERED.get());
            return false;
        }

        String newPassword = args[1];

        // Check if password is safe
        if (!Security.checkPassword(newPassword, player)) return false;

        // Encrypt password
        String oldPassword = Security.hashPassword(args[0]);
        newPassword = Security.hashPassword(args[1]);


        // Check if encryption failed
        if (oldPassword == null || newPassword == null) {
            Chat.reply(player, Lang.REGISTER_ERROR.get());
            return false;
        }

        // Get session manager
        SessionManager sm = LoginModule.getSessionManager();

        // Check if player is registered
        if (!sm.verifySession(player, oldPassword)) {
            Chat.reply(player, Lang.BAD_PASSWORD.get());
            return false;
        }

        // Change password
        sm.changePassword(player, newPassword);
        Chat.reply(player, Lang.PASS_CHANGE.get());
        return true;
    }
}
