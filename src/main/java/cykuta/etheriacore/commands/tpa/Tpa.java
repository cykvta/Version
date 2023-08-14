package cykuta.etheriacore.commands.tpa;

import cykuta.etheriacore.commands.CoreCommand;
import cykuta.etheriacore.files.lang.Lang;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tpa extends CoreCommand {

    public Tpa(){
        setAllowConsole(false);
    }

    @Override
    public boolean exec(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if(args.length != 1){
            Chat.reply(player, Lang.USAGE.get().replaceAll("%usage%", usage));
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null){
            Chat.reply(player, Lang.NO_PLAYER.get());
            return false;
        }

        if (target == player){
            Chat.reply(player, Lang.AUTO_TARGET.get());
            return false;
        }

        TpaRequest.newRequest(player, target);

        Chat.reply(player, Lang.TELEPORT_SEND.get().replaceAll("%player%", target.getName()));
        Chat.reply(target, Lang.TELEPORT_REQUEST.get().replaceAll("%player%", player.getName()));
        Chat.reply(target, Lang.TELEPORT_ACTIONS.get().replaceAll("%player%", player.getName()));
        return true;
    }
}
