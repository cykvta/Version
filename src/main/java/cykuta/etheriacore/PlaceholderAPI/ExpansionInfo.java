package cykuta.etheriacore.PlaceholderAPI;

import cykuta.etheriacore.EtheriaCore;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;

public class ExpansionInfo extends PlaceholderExpansion {
    EtheriaCore plugin;
    public ExpansionInfo(EtheriaCore plugin){
        this.plugin = plugin;
    }

    @Override
    public String getIdentifier() {
        return "EtheriaCore";
    }

    @Override
    public String getAuthor() {
        return "Cykuta";
    }

    @Override
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public  String onRequest(OfflinePlayer player, String params) {
        if(params.equalsIgnoreCase("name")){
            return player == null ? null : player.getName();
        }
        return null;
    }
}
