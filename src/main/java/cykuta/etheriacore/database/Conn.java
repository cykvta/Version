package cykuta.etheriacore.database;

import cykuta.etheriacore.config.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    private Connection connection;

    public Conn() throws SQLException {
        String ip = Config.DATABASE_IP.getPureString();
        String port = Config.DATABASE_PORT.getPureString();
        String user = Config.DATABASE_USER.getPureString();
        String password = Config.DATABASE_PASSWORD.getPureString();
        String database = Config.DATABASE_DATABASE.getPureString();

        String url = String.format("jdbc:mysql://%s:%s/%s", ip, port, database);
        this.connection = DriverManager.getConnection(url , user, password);
    }

    public Connection getConnection(){
        return connection;
    }
}
