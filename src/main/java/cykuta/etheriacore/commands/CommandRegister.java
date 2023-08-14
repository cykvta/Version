package cykuta.etheriacore.commands;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.commands.home.DelHome;
import cykuta.etheriacore.commands.home.Home;
import cykuta.etheriacore.commands.home.SetHome;
import cykuta.etheriacore.commands.shortcuts.gamemode.GamemodeChanger;
import cykuta.etheriacore.commands.shortcuts.gamemode.GamemodeType;
import cykuta.etheriacore.commands.shortcuts.time.TimeChanger;
import cykuta.etheriacore.commands.shortcuts.time.WeatherChanger;
import cykuta.etheriacore.commands.shortcuts.time.WeatherType;
import cykuta.etheriacore.commands.tpa.Tpa;
import cykuta.etheriacore.commands.tpa.Tpaccept;
import cykuta.etheriacore.commands.tpa.Tpdeny;

public enum CommandRegister {
    TPA("tpa", new Tpa(), "core.tp"),
    TPACCEPT("tpaccept", new Tpaccept(), "core.tp"),
    TPDENY("tpdeny", new Tpdeny(), "core.tp"),
    CREATIVE("creative", new GamemodeChanger(GamemodeType.CREATIVE), "core.gamemode"),
    SURVIVAL("survival", new GamemodeChanger(GamemodeType.SURVIVAL), "core.gamemode"),
    ADVENTURE("adventure", new GamemodeChanger(GamemodeType.ADVENTURE), "core.gamemode"),
    SPECTATOR("spectator", new GamemodeChanger(GamemodeType.SPECTATOR), "core.gamemode"),
    DAY("day", new TimeChanger(0), "core.time"),
    NIGHT("night", new TimeChanger(15000), "core.time"),
    SUN("sun", new WeatherChanger(WeatherType.SUN), "core.weather"),
    RAIN("rain", new WeatherChanger(WeatherType.RAIN), "core.weather"),
    THUNDER("thunder", new WeatherChanger(WeatherType.THUNDER), "core.weather"),
    SETHOME("sethome", new SetHome(), "core.home"),
    DELHOME("delhome", new DelHome(), "core.home"),
    HOME("home", new Home(), "core.home")
    ;

    private final String command;
    private final CoreCommand executor;
    private final EtheriaCore plugin;
    private final String permission;

    CommandRegister(String command, CoreCommand executor, String permission){
        this.command = command;
        this.executor = executor;
        this.permission = permission;
        this.plugin = EtheriaCore.getPlugin();
    }

    private void register() {
        plugin.getCommand(command).setExecutor(executor);
        executor.setPermission(permission);
    }

    // Static method to register all commands
    public static void registerCommands() {
        CommandRegister[] commands = CommandRegister.values();
        for (CommandRegister command : commands) {
            command.register();
        }
    }
}
