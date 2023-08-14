package cykuta.etheriacore.modules.shortcuts.commands;

import cykuta.etheriacore.CoreCommand;
import cykuta.etheriacore.files.lang.Lang;
import cykuta.etheriacore.modules.shortcuts.utils.GamemodeType;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeChanger extends CoreCommand {
    private final GamemodeType gamemode;
    public GamemodeChanger(GamemodeType gamemode){
        this.gamemode = gamemode;
        setAllowConsole(false);
    }

    @Override
    public boolean exec(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        String gmName = gamemode.getLang().get();

        if (args.length == 0){
            player.setGameMode(gamemode.getGameMode());
            Chat.reply(player, Lang.GAMEMODE.get().replaceAll("%gamemode%", gmName));
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null){
            Chat.reply(player, Lang.NO_PLAYER.get());
            return false;
        }

        target.setGameMode(gamemode.getGameMode());
        Chat.reply(player, Lang.GAMEMODE_OTHER.get()
                .replaceAll("%gamemode%", gmName)
                .replaceAll("%player%", target.getName()));

        Chat.reply(target, Lang.GAMEMODE.get()
                .replaceAll("%gamemode%", gmName));

        return true;
    }
}
