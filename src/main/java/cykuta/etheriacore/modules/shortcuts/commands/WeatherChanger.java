package cykuta.etheriacore.modules.shortcuts.commands;

import cykuta.etheriacore.CoreCommand;
import cykuta.etheriacore.files.lang.Lang;
import cykuta.etheriacore.modules.shortcuts.utils.WeatherType;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeatherChanger extends CoreCommand {
    private final WeatherType weather;
    public WeatherChanger(WeatherType weather){
        this.weather = weather;
        setAllowConsole(true);
    }

    @Override
    public boolean exec(CommandSender sender, String[] args) {
        World world;

        if (!(sender instanceof Player)) {
            if (args.length == 0){
                Chat.consoleMsg(Lang.USAGE.get().replaceAll("%usage%", usage));
                return false;
            }

            world = Bukkit.getServer().getWorld(args[0]);

            if (world == null){
                Chat.consoleMsg(Lang.WEATHER_WORLD.get().replaceAll("%world%", args[0]));
                return false;
            }

            Chat.consoleMsg(Lang.WEATHER_SET.get()
                    .replaceAll("%world%", world.getName())
                    .replaceAll("%weather%", weather.getLang().get()));
        }else {
            Player player = (Player) sender;
            world = player.getWorld();
            Chat.reply(player, Lang.WEATHER_SET.get()
                    .replaceAll("%world%", world.getName())
                    .replaceAll("%weather%", weather.getLang().get()));
        }

        switch (weather){
            case SUN:
                world.setStorm(false);
                world.setThundering(false);
                break;
            case RAIN:
                world.setStorm(true);
                world.setThundering(false);
                break;
            case THUNDER:
                world.setStorm(true);
                world.setThundering(true);
                break;
        }
        return true;
    }
}