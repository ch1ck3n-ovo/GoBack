package tw.ch1ck3n.goback.utils;

import org.bukkit.command.CommandSender;
import tw.ch1ck3n.goback.GoBack;

public class ChatUtils {

    public static boolean sendMessage(CommandSender sender, String message) {
        sender.sendMessage(
                GoBack.INSTANCE.getMessages().prefix + " " + message
        );
        return true;
    }

    public static boolean sendNoPermissionMessage(CommandSender sender, String permission) {
        sender.sendMessage(
                GoBack.INSTANCE.getMessages().prefix + " " +
                GoBack.INSTANCE.getMessages().noCommandPermission
        );
        return true;
    }
}
