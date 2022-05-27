package cykuta.etheriacore.commands.shortcuts.time;

import cykuta.etheriacore.lang.LangError;
import cykuta.etheriacore.lang.LangSuccess;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WeatherChanger implements CommandExecutor {
    private final WeatherTypes weather;
    public WeatherChanger(WeatherTypes weather){
        this.weather = weather;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        World world;
        if (!(sender instanceof Player)) {
            if (args.length == 0){
                Chat.consoleMsg(LangError.USAGE.value.replaceAll("%usage%", command.getUsage()));
                return false;
            }
            world = Bukkit.getServer().getWorld(args[0]);

            if (world == null){
                Chat.consoleMsg(LangError.WEATHER_WORLD.value.replaceAll("%world%", args[0]));
                return false;
            }

            Chat.consoleMsg(LangSuccess.WEATHER_SET.value
                    .replaceAll("%world%", world.getName())
                    .replaceAll("%weather%", String.valueOf(weather.name())));
        }else {
            Player player = (Player) sender;
            world = player.getWorld();
            Chat.playerMsg(player, LangSuccess.WEATHER_SET.value
                    .replaceAll("%world%", world.getName())
                    .replaceAll("%weather%", String.valueOf(weather.name())));
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