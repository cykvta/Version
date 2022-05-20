package cykuta.etheriacore.Utils;

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

    //Constructor
    public VersionChecker(EtheriaCore plugin) {
        this.plugin = plugin;
    };

    //Verifica si el string es la version correcta
    public static boolean checkUpdates(String version){
        try{
            String r = getRequest("https://cykvta.github.io/EtheriaCore/EtheriaCore.txt");
            if (!r.equals(version)) return true;
        }catch (Exception e){
            Bukkit.getConsoleSender().sendMessage(Chat.color("&c[FATAL ERROR] Hay un error interno en" +
                    " EtheriaCore porfavor validalo antes de continuar cod: "+ e));
        }
        return false;
    }

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

    //Mensaje a la consola del server
    public static void sendConsoleMessage(){
        ConsoleCommandSender console = Bukkit.getConsoleSender();
        console.sendMessage(Chat.color(""));
        console.sendMessage(Chat.color("&6ETHERIA CORE"));
        console.sendMessage(Chat.color("&aEl plugin tiene una Actualizacion disponible"));
        console.sendMessage(Chat.color(""));
    }
}
