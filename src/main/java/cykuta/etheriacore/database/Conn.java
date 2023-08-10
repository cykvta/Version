package cykuta.etheriacore.database;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.config.Config;
import cykuta.etheriacore.config.ConfigManager;

import java.sql.*;

public class Conn {
    private Connection connection;

    public Conn() throws SQLException {
        if (ConfigManager.getBoolean("use-mysql")) useMysql();
        else useSqlite();

        // Create tables
        createHomeTable();
    }

    // Mysql Connection
    private void useMysql() throws SQLException {
        String ip = Config.DATABASE_IP.getPureString();
        String port = Config.DATABASE_PORT.getPureString();
        String user = Config.DATABASE_USER.getPureString();
        String password = Config.DATABASE_PASSWORD.getPureString();
        String database = Config.DATABASE_DATABASE.getPureString();

        String url = String.format("jdbc:mysql://%s:%s/%s", ip, port, database);
        this.connection = DriverManager.getConnection(url, user, password);
    }

    // Sqlite Connection
    private void useSqlite() throws SQLException {
        String url = String.format("jdbc:sqlite:%s", EtheriaCore.getProvidingPlugin(EtheriaCore.class).getDataFolder().getPath() + "/database.db");
        this.connection = DriverManager.getConnection(url);
    }

    // Create home table
    private void createHomeTable() throws SQLException {
        Statement stmt = getConnection().createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS home (uid VARCHAR(36), x DOUBLE, y DOUBLE, z DOUBLE, yaw FLOAT, pitch FLOAT, world VARCHAR(36))");
    }

    // Get connection
    public Connection getConnection(){
        return connection;
    }
}
