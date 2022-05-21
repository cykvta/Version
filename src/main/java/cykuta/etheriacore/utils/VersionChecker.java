package cykuta.etheriacore.utils;

import cykuta.etheriacore.EtheriaCore;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class VersionChecker {
    public EtheriaCore plugin;
    public static boolean oldVersion = false;
    private static String url;

    //Constructor
    public VersionChecker(EtheriaCore plugin) {
        this.plugin = plugin;
        ConfigManager cfg = new ConfigManager(plugin);
        url = cfg.getVersionUrl();
    };

    //Response desde web
    public static String getRequest(String url) throws IOException{
        URL web = new URL(url);
        HttpURLConnection con = (HttpURLConnection) web.openConnection();
        con.setRequestMethod("GET");
        BufferedReader input = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = input.readLine()) != null){
            response.append(inputLine);
        }
        input.close();
        return response.toString();
    }

    //Verifica si el string es la version correcta
    public boolean checkUpdates(String version){
        try{
            String r = getRequest(url);
            if (!r.equals(version)) return true;
        }catch (Exception e){
            Bukkit.getConsoleSender().sendMessage(Chat.color("&c[FATAL ERROR] Error en la config: version_url"));
        }
        return false;
    }

    //Mensaje a la consola del server
    public static void sendConsoleMessage(){
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(Chat.color(""));
        console.sendMessage(Chat.color("&6ETHERIA CORE"));
        console.sendMessage(Chat.color("&aEl plugin tiene una Actualizacion disponible"));
        console.sendMessage(Chat.color(""));
    }
}
