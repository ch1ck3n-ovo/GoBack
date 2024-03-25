package tw.ch1ck3n.goback.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tw.ch1ck3n.goback.GoBack;
import tw.ch1ck3n.goback.configs.Messages;
import tw.ch1ck3n.goback.configs.Settings;
import tw.ch1ck3n.goback.utils.ChatUtils;
import tw.ch1ck3n.goback.utils.CustomPlayer;

public class BackCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Messages messages = GoBack.INSTANCE.getMessages();
        Settings settings = GoBack.INSTANCE.getSettings();
        if (!(sender instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(messages.executeInConsole);
            return true;
        }

        if (!sender.hasPermission("gb.back")) return ChatUtils.sendNoPermissionMessage(sender, "gb.back");

        CustomPlayer p = GoBack.INSTANCE.getPlayerManager().getPlayer(((Player) sender).getPlayer());
        if (args.length == 0) {
            if (!p.isTped()) {
                if (!p.hasTimePassed(settings.keepTime)) {
                    if (p.getPlayer().getLastDeathLocation() != null) {
                        p.getPlayer().teleport(p.getPlayer().getLastDeathLocation());
                        p.setTped(true);
                        return ChatUtils.sendMessage(sender, messages.playerTeleport);
                    } else {
                        return ChatUtils.sendMessage(sender, messages.noDeathLocationFound);
                    }
                } else {
                    return ChatUtils.sendMessage(sender, messages.timedOut);
                }
            } else {
                return ChatUtils.sendMessage(sender, messages.alreadyTeleported);
            }
        }

        return true;
    }

}
