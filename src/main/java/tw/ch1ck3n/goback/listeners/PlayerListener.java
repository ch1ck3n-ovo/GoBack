package tw.ch1ck3n.goback.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import tw.ch1ck3n.goback.GoBack;
import tw.ch1ck3n.goback.configs.Messages;
import tw.ch1ck3n.goback.utils.ChatUtils;
import tw.ch1ck3n.goback.utils.CustomPlayer;

public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        GoBack.INSTANCE.getPlayerManager().register(e.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        GoBack.INSTANCE.getPlayerManager().unregister(e.getPlayer());
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        CustomPlayer p = GoBack.INSTANCE.getPlayerManager().getPlayer(e.getEntity());
        p.setLastDeathTime(System.currentTimeMillis());
        p.setTped(false);
        Messages messages = GoBack.INSTANCE.getMessages();
        ChatUtils.sendMessage(p.getPlayer(), messages.canExecuteCommand);
    }
}
