package tw.ch1ck3n.goback.utils;

import org.bukkit.entity.Player;

public class CustomPlayer {

    private long lastDeathTime;

    private final Player player;

    private boolean tped;

    public CustomPlayer(Player player) {
        this.player = player;
        this.lastDeathTime = System.currentTimeMillis();
        this.tped = true;
    }

    public Player getPlayer() {
        return this.player;
    }

    public boolean hasTimePassed(long time) {
        return (System.currentTimeMillis() >= lastDeathTime + time);
    }

    public void setLastDeathTime(long lastDeathTime) {
        this.lastDeathTime = lastDeathTime;
    }

    public boolean isTped() {
        return tped;
    }

    public void setTped(boolean tped) {
        this.tped = tped;
    }
}
