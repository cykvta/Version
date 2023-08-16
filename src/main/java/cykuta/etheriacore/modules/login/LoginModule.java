package cykuta.etheriacore.modules.login;

import cykuta.etheriacore.modules.CoreModule;
import cykuta.etheriacore.modules.login.commands.ChangePassword;
import cykuta.etheriacore.modules.login.commands.Login;
import cykuta.etheriacore.modules.login.commands.Register;
import cykuta.etheriacore.modules.login.events.JoinPlayer;
import cykuta.etheriacore.modules.login.events.PreventMove;
import cykuta.etheriacore.modules.login.utils.SessionManager;

public class LoginModule extends CoreModule {
    private static SessionManager sessionManager;

    @Override
    public void registerCommands() {
        registerCommand(new Register(), "register", "core.auth");
        registerCommand(new Login(), "login", "core.auth");
        registerCommand(new ChangePassword(), "changepassword", "core.auth");
    }

    @Override
    public void registerEvents() {
        registerEvent(new PreventMove());
        registerEvent(new JoinPlayer());
    }

    @Override
    public void registerOthers() {
        try {
            sessionManager = new SessionManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getSessionManager() {
        return sessionManager;
    }
}
