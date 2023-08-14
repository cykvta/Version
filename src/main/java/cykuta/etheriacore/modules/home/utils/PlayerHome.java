package cykuta.etheriacore.modules.home.utils;

import cykuta.etheriacore.EtheriaCore;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayerHome{
    private final Player player;
    private final Connection conn;
    private final Statement stmt;

    public PlayerHome(Player player) throws SQLException {
        this.player = player;
        this.conn = EtheriaCore.getConn().getConnection();
        this.stmt = conn.createStatement();
    }

    public boolean hasHome() throws SQLException {
        String query = String.format("SELECT * FROM home WHERE uid = '%s'", player.getUniqueId());
        ResultSet rs = stmt.executeQuery(query);
        return rs.next();
    }

    public Location getHomeLocation() throws SQLException {
        String query = String.format("SELECT * FROM home WHERE uid = '%s'", player.getUniqueId());
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()){
            double x = rs.getDouble("x");
            double y = rs.getDouble("y");
            double z = rs.getDouble("z");
            float yaw = rs.getFloat("yaw");
            float pitch = rs.getFloat("pitch");
            String worlds = rs.getString("world");

            World world = Bukkit.getServer().getWorld(worlds);
            if(world == null) return null;
            return new Location(world, x, y, z, yaw, pitch);
        }
        return null;
    }

    public void setHome(Location location) throws SQLException {
        String uid = String.valueOf(player.getUniqueId());
        String x = String.valueOf(location.getX());
        String y = String.valueOf(location.getY());
        String z = String.valueOf(location.getZ());
        String yaw = String.valueOf(location.getYaw());
        String pitch = String.valueOf(location.getPitch());
        String world = location.getWorld().getName();

        String query = String.format("INSERT INTO home VALUES ('%s', '%s', '%s', '%s','%s' ,'%s' ,'%s')", uid, x, y, z, yaw, pitch, world);
        stmt.execute(query);
    }

    public void removeHome(Player player) throws SQLException {
        String uid = String.valueOf(player.getUniqueId());

        String query = String.format("DELETE FROM home WHERE uid = '%s'", uid);
        stmt.execute(query);
    }
}