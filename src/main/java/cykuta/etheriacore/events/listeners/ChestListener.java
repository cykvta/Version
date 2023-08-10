package cykuta.etheriacore.events.listeners;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.events.Event;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;

public class ChestListener extends Event {
    public ChestListener(EtheriaCore plugin) {
        super(plugin);
    }

    @EventHandler
    public void onChestOpen(PlayerInteractEvent e) {
        // TODO:
        //  - Add chest open event
    }
}
