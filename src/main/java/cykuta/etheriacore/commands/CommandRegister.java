package cykuta.etheriacore.commands;

import cykuta.etheriacore.commands.home.DelHome;
import cykuta.etheriacore.commands.home.Home;
import cykuta.etheriacore.commands.home.SetHome;
import cykuta.etheriacore.commands.shortcuts.gamemode.GamemodeChanger;
import cykuta.etheriacore.commands.shortcuts.time.TimeChanger;
import cykuta.etheriacore.commands.shortcuts.time.WeatherTypes;
import cykuta.etheriacore.commands.shortcuts.time.WeatherChanger;
import cykuta.etheriacore.commands.tpa.Tpa;
import cykuta.etheriacore.commands.tpa.Tpaccept;
import cykuta.etheriacore.commands.tpa.Tpdeny;
import cykuta.etheriacore.EtheriaCore;
import org.bukkit.GameMode;

public class CommandRegister {
    private final EtheriaCore plugin;

    public CommandRegister(EtheriaCore plugin){
        this.plugin = plugin;
    }

    public void registerCommands(){
        plugin.getCommand("tpa").setExecutor(new Tpa(plugin));
        plugin.getCommand("tpaccept").setExecutor(new Tpaccept(plugin));
        plugin.getCommand("tpdeny").setExecutor(new Tpdeny(plugin));

        plugin.getCommand("creative").setExecutor(new GamemodeChanger(GameMode.CREATIVE));
        plugin.getCommand("survival").setExecutor(new GamemodeChanger(GameMode.SURVIVAL));
        plugin.getCommand("adventure").setExecutor(new GamemodeChanger(GameMode.ADVENTURE));
        plugin.getCommand("spectator").setExecutor(new GamemodeChanger(GameMode.SPECTATOR));

        plugin.getCommand("day").setExecutor(new TimeChanger(0));
        plugin.getCommand("night").setExecutor(new TimeChanger(18000));


        plugin.getCommand("sun").setExecutor(new WeatherChanger(WeatherTypes.SUN));
        plugin.getCommand("rain").setExecutor(new WeatherChanger(WeatherTypes.RAIN));
        plugin.getCommand("thunder").setExecutor(new WeatherChanger(WeatherTypes.THUNDER));

        plugin.getCommand("sethome").setExecutor(new SetHome());
        plugin.getCommand("delhome").setExecutor(new DelHome());
        plugin.getCommand("home").setExecutor(new Home());
    }
}
