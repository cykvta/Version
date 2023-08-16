package cykuta.etheriacore.modules.login.commands;

import cykuta.etheriacore.CoreCommand;
import cykuta.etheriacore.files.lang.Lang;
import cykuta.etheriacore.modules.login.LoginModule;
import cykuta.etheriacore.modules.login.utils.Security;
import cykuta.etheriacore.modules.login.utils.Session;
import cykuta.etheriacore.modules.login.utils.SessionManager;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class Login extends CoreCommand {
    public Login() {
        setAllowConsole(false);
    }
    @Override
    public boolean exec(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        // Check if command is used correctly
        if (args.length != 1)  {
            Chat.reply(player, Lang.USAGE.get().replace("%usage%", usage));
            return false;
        }

        Session session = Session.getSession(player);

        // Check if player is already logged in
        if (session != null) {
            Chat.reply(player, Lang.ALREADY_LOGGED_IN.get());
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

        // Check if player is registered and verify password
        if (!sm.isRegistered(player)) {
            Chat.reply(player, Lang.NOT_REGISTERED.get());
            return false;
        }

        if (!sm.verifySession(player, password)) {
            Chat.reply(player, Lang.BAD_PASSWORD.get());
            return false;
        }

        // Login player
        Chat.reply(player, Lang.LOGIN_SUCCESS.get());
        session = new Session(player);

        session.setLoggedIn(true);

        return false;
    }
}
