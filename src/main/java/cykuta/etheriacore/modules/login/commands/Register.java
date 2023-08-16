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

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Objects;

public class Register extends CoreCommand {
    public Register() {
        setAllowConsole(false);
    }
    @Override
    public boolean exec(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if (args.length != 2)  {
            Chat.reply(player, Lang.USAGE.get().replace("%usage%", usage));
            return false;
        }

        Session session = Session.getSession(player);

        // Check if player is already logged in
        if (session != null) {
            Chat.reply(player, Lang.ALREADY_LOGGED_IN.get());
            return false;
        }

        if (!Objects.equals(args[0], args[1])) {
            Chat.reply(player, Lang.PASSWORD_NOT_MATCH.get());
            return false;
        }

        // Check if password is safe
        if (!Security.checkPassword(args[0], player)) return false;

        // Encrypt password
        String password = Security.hashPassword(args[0]);

        // Check if encryption failed
        if (password == null) {
            Chat.reply(player, Lang.REGISTER_ERROR.get());
            return false;
        }

        // Get session manager
        SessionManager sm = LoginModule.getSessionManager();

        // Check if player is registered
        if (sm.isRegistered(player)) {
            Chat.reply(player, Lang.ALREADY_REGISTERED.get());
            return false;
        }

        // Register session to database
        session = new Session(player);
        sm.registerSession(session, password);

        // Set session logged in and reply
        session.setLoggedIn(true);
        Chat.reply(player, Lang.REGISTER_SUCCESS.get());

        return true;
    }
}
