package cykuta.etheriacore.commands;

import cykuta.etheriacore.EtheriaCore;
import cykuta.etheriacore.files.lang.Lang;
import cykuta.etheriacore.utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public abstract class CoreCommand implements CommandExecutor {

    private boolean allowConsole;
    protected String usage;
    protected String permission;
    protected final EtheriaCore plugin = EtheriaCore.getPlugin();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        // Set usage
        usage = command.getUsage();

        // Check if sender is console
        if (!allowConsole && !(sender instanceof Player)) {
            Chat.consoleMsg(Lang.PLAYER_COMMAND.get());
            return false;
        }

        // Check permission
        if (permission != null && !sender.hasPermission(permission)) {
            Chat.reply(sender, Lang.NO_PERMISSION.get());
            return false;
        }

        return exec(sender, strings);
    }

    public abstract boolean exec(CommandSender sender, String[] args);

    // Setters
    public void setAllowConsole(boolean allowConsole) {
        this.allowConsole = allowConsole;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
