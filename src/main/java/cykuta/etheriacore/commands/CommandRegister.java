package cykuta.etheriacore.commands;

import cykuta.etheriacore.commands.tpa.Tpa;
import cykuta.etheriacore.commands.tpa.Tpaccept;
import cykuta.etheriacore.commands.tpa.Tpdeny;
import cykuta.etheriacore.EtheriaCore;

public class CommandRegister {
    private final EtheriaCore plugin;

    public CommandRegister(EtheriaCore plugin){
        this.plugin = plugin;
    }

    public void registerCommands(){
        plugin.getCommand("tpa").setExecutor(new Tpa(plugin));
        plugin.getCommand("tpaccept").setExecutor(new Tpaccept());
        plugin.getCommand("tpdeny").setExecutor(new Tpdeny());
    }
}
