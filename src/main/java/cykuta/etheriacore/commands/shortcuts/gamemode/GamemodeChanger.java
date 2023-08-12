package cykuta.etheriacore.commands.shortcuts.gamemode;

import cykuta.etheriacore.files.lang.LangError;
import cykuta.etheriacore.files.lang.LangSuccess;
import cykuta.etheriacore.utils.Chat;
import cykuta.etheriacore.utils.CommandUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeChanger implements CommandExecutor {
    private GameMode gamemode;
    public GamemodeChanger(GameMode gamemode){
        this.gamemode = gamemode;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!CommandUtils.isPlayer(sender)) return false;
        Player player = (Player) sender;
        if (args.length == 0){
            player.setGameMode(gamemode);
            Chat.playerMsg(player, LangSuccess.GAMEMODE.value.replaceAll("%gamemode%", gamemode.name()));
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null){
            Chat.playerMsg(player, LangError.NO_PLAYER.value);
            return false;
        }

        target.setGameMode(gamemode);
        Chat.playerMsg(player, LangSuccess.GAMEMODE_OTHER.value
                .replaceAll("%gamemode%", gamemode.name())
                .replaceAll("%player%", target.getName()));

        Chat.playerMsg(target, LangSuccess.GAMEMODE.value
                .replaceAll("%gamemode%", gamemode.name()));

        return true;
    }
}
