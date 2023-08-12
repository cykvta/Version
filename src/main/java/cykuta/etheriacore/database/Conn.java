package cykuta.etheriacore.database;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.files.config.Config;

import java.sql.*;

public class Conn {
    private Connection connection;

    public Conn() throws SQLException {
        if (Config.USE_MYSQL.getBoolean()) useMysql();
        else useSqlite();

        // Create tables
        createHomeTable();
    }

    // Mysql Connection
    private void useMysql() throws SQLException {
        String ip = Config.DATABASE_IP.getString();
        String port = Config.DATABASE_PORT.getString();
        String user = Config.DATABASE_USER.getString();
        String password = Config.DATABASE_PASSWORD.getString();
        String database = Config.DATABASE_DATABASE.getString();

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
