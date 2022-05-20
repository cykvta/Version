package cykuta.etheriacore.Events;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.Utils.ConfigManager;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class BlockCraft implements Listener {
    private final EtheriaCore plugin;
    private ConfigManager cfg;

    public BlockCraft(EtheriaCore plugin){
        this.plugin = plugin;
        this.cfg = new ConfigManager(plugin);
    }

    @EventHandler
    public void banCraft(CraftItemEvent e){
        /*LOG*/ plugin.getServer().getConsoleSender().sendMessage("HOLA 1");
        ItemStack result = e.getInventory().getResult();
        if(cfg.getBannedItems().contains(result)){
            /*LOG*/ plugin.getServer().getConsoleSender().sendMessage("PASA IF");
            e.setCancelled(true);
        }
    }
}
