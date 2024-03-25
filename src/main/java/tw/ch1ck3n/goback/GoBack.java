package tw.ch1ck3n.goback;

import org.bukkit.plugin.java.JavaPlugin;
import tw.ch1ck3n.goback.commands.BackCommand;
import tw.ch1ck3n.goback.configs.Messages;
import tw.ch1ck3n.goback.configs.Settings;
import tw.ch1ck3n.goback.listeners.PlayerListener;
import tw.ch1ck3n.goback.managers.PlayerManager;

public final class GoBack extends JavaPlugin {

    public static GoBack INSTANCE;

    private PlayerManager playerManager;

    private Settings settings;

    private Messages messages;

    @Override
    public void onEnable() {
        INSTANCE = this;
        this.playerManager = new PlayerManager();

        this.saveDefaultConfig();

        this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        this.getCommand("back").setExecutor(new BackCommand());

        this.messages = new Messages();
        this.settings = new Settings();
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public Messages getMessages() {
        return messages;
    }

    public Settings getSettings() {
        return settings;
    }
}
