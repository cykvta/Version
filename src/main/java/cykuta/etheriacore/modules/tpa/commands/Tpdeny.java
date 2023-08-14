package cykuta.etheriacore.modules.tpa.commands;

import cykuta.etheriacore.CoreCommand;
import cykuta.etheriacore.files.lang.Lang;
import cykuta.etheriacore.modules.tpa.utils.TpaRequest;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tpdeny extends CoreCommand {

    public Tpdeny(){
        setAllowConsole(false);
    }

    @Override
    public boolean exec(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if (!TpaRequest.hasRequest(player)){
            Chat.reply(player, Lang.TELEPORT_NO_REQUEST.get());
            return false;
        }

        Player tpSender = TpaRequest.fetchPlayer(player);
        TpaRequest.removeRequest(player);
        Chat.reply(player, Lang.TELEPORT_REJECT.get().replaceAll("%player%", tpSender.getName()));
        Chat.reply(tpSender, Lang.TELEPORT_REJECTED.get().replaceAll("%player%", player.getName()));
        return false;
    }
}
