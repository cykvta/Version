package cykuta.etheriacore.commands;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.commands.home.DelHome;
import cykuta.etheriacore.commands.home.Home;
import cykuta.etheriacore.commands.home.SetHome;
import cykuta.etheriacore.commands.shortcuts.gamemode.GamemodeChanger;
import cykuta.etheriacore.commands.shortcuts.time.TimeChanger;
import cykuta.etheriacore.commands.shortcuts.time.WeatherChanger;
import cykuta.etheriacore.commands.shortcuts.time.WeatherTypes;
import cykuta.etheriacore.commands.tpa.Tpa;
import cykuta.etheriacore.commands.tpa.Tpaccept;
import cykuta.etheriacore.commands.tpa.Tpdeny;
import org.bukkit.GameMode;
import org.bukkit.command.CommandExecutor;

public enum CommandRegister {
    TPA("tpa", new Tpa()),
    TPACCEPT("tpaccept", new Tpaccept()),
    TPDENY("tpdeny", new Tpdeny()),
    CREATIVE("creative", new GamemodeChanger(GameMode.CREATIVE)),
    SURVIVAL("survival", new GamemodeChanger(GameMode.SURVIVAL)),
    ADVENTURE("adventure", new GamemodeChanger(GameMode.ADVENTURE)),
    SPECTATOR("spectator", new GamemodeChanger(GameMode.SPECTATOR)),
    DAY("day", new TimeChanger(0)),
    NIGHT("night", new TimeChanger(15000)),
    SUN("sun", new WeatherChanger(WeatherTypes.SUN)),
    RAIN("rain", new WeatherChanger(WeatherTypes.RAIN)),
    THUNDER("thunder", new WeatherChanger(WeatherTypes.THUNDER)),
    SETHOME("sethome", new SetHome()),
    DELHOME("delhome", new DelHome()),
    HOME("home", new Home())
    ;

    private final String command;
    private final CommandExecutor executor;
    private final EtheriaCore plugin;

    CommandRegister(String command, CommandExecutor executor){
        this.command = command;
        this.executor = executor;
        this.plugin = EtheriaCore.getPlugin();
    }

    private void register() {
        plugin.getCommand(command).setExecutor(executor);
    }

    public static void registerCommands() {
        CommandRegister[] commands = CommandRegister.values();

        // Register all commands
        for (CommandRegister command : commands) {
            command.register();
        }
    }
}
