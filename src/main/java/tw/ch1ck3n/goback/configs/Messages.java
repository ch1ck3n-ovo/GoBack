package tw.ch1ck3n.goback.configs;

import tw.ch1ck3n.goback.GoBack;

public class Messages {

    public final String prefix = "§7[§aGoBack§7]§r";

    public final String alreadyTeleported;

    public final String canExecuteCommand;

    public final String executeInConsole;

    public final String noCommandPermission;

    public final String noDeathLocationFound;

    public final String playerTeleport;

    public final String timedOut;

    public Messages() {
        this.alreadyTeleported = GoBack.INSTANCE.getConfig().getString("message.already-teleported").replaceAll("&", "§");
        this.canExecuteCommand = GoBack.INSTANCE.getConfig().getString("message.can-execute-command").replaceAll("&", "§");
        this.executeInConsole = GoBack.INSTANCE.getConfig().getString("message.execute-in-console").replaceAll("&", "§");
        this.noCommandPermission = GoBack.INSTANCE.getConfig().getString("message.no-command-permission").replaceAll("&", "§");
        this.noDeathLocationFound = GoBack.INSTANCE.getConfig().getString("message.no-death-location-found").replaceAll("&", "§");
        this.playerTeleport = GoBack.INSTANCE.getConfig().getString("message.player-teleport").replaceAll("&", "§");
        this.timedOut = GoBack.INSTANCE.getConfig().getString("message.timed-out").replaceAll("&", "§");
    }
}
