package cykuta.etheriacore.modules.login.utils;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Session {
    private static final ArrayList<Session> sessions = new ArrayList<>();
    private final Player player;
    private boolean loggedIn;

    public Session(Player player) {
        this.player = player;
        this.loggedIn = false;
        sessions.add(this);
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isAutorized() {
        return loggedIn;
    }

    public void destroy() {
        sessions.remove(this);
    }

    public void setLoggedIn(boolean log) {
        this.loggedIn = log;
    }

    public static Session getSession(Player player) {
        for (Session session : sessions) {
            if (session.getPlayer().equals(player)) {
                return session;
            }
        }
        return null;
    }
}
