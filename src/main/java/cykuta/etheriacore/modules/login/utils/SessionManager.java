package cykuta.etheriacore.modules.login.utils;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.files.config.Config;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SessionManager {
    private final Connection conn;
    private final Statement stmt;

    public SessionManager() throws SQLException {
        this.conn = EtheriaCore.getConn().getConnection();
        this.stmt = conn.createStatement();
    }

    public void registerSession(Session session, String password) {
        String q = String.format("INSERT INTO login VALUES ('%s', '%s')", session.getPlayer().getUniqueId(), password);

        try { this.stmt.execute(q); }
        catch (SQLException e) { throw new RuntimeException(e); }
    }

    public boolean verifySession(Player player, String password) {
        String q = String.format("SELECT * FROM login WHERE uid = '%s' AND password = '%s'", player.getUniqueId(), password);

        try { return this.stmt.executeQuery(q).next(); }
        catch (SQLException e) { throw new RuntimeException(e); }
    }

    public boolean isRegistered(Player player) {
        String q = String.format("SELECT * FROM login WHERE uid = '%s'", player.getUniqueId());

        try { return this.stmt.executeQuery(q).next(); }
        catch (SQLException e) { throw new RuntimeException(e); }
    }

    public void changePassword(Player player, String newPassword) {
        String q = String.format("UPDATE login SET password = '%s' WHERE uid = '%s'", newPassword, player.getUniqueId());

        try { this.stmt.execute(q); }
        catch (SQLException e) { throw new RuntimeException(e); }
    }
}
