package cykuta.etheriacore.modules.shortcuts;

import cykuta.etheriacore.modules.CoreModule;
import cykuta.etheriacore.modules.shortcuts.commands.GamemodeChanger;
import cykuta.etheriacore.modules.shortcuts.commands.TimeChanger;
import cykuta.etheriacore.modules.shortcuts.commands.WeatherChanger;
import cykuta.etheriacore.modules.shortcuts.utils.GamemodeType;
import cykuta.etheriacore.modules.shortcuts.utils.WeatherType;

public class ShortcutsModule extends CoreModule {
    @Override
    public void registerCommands() {
        registerCommand(new GamemodeChanger(GamemodeType.CREATIVE), "creative", "core.gamemode");
        registerCommand(new GamemodeChanger(GamemodeType.SURVIVAL), "survival", "core.gamemode");
        registerCommand(new GamemodeChanger(GamemodeType.ADVENTURE), "adventure", "core.gamemode");
        registerCommand(new GamemodeChanger(GamemodeType.SPECTATOR), "spectator", "core.gamemode");
        registerCommand(new TimeChanger(0), "day", "core.time");
        registerCommand(new TimeChanger(16000), "night", "core.time");
        registerCommand(new WeatherChanger(WeatherType.SUN), "sun", "core.weather");
        registerCommand(new WeatherChanger(WeatherType.RAIN), "rain", "core.weather");
        registerCommand(new WeatherChanger(WeatherType.THUNDER), "thunder", "core.weather");
    }

    @Override
    public void registerEvents() {

    }

    @Override
    public void registerOthers() {

    }
}
