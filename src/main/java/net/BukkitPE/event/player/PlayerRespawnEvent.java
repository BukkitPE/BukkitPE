package net.BukkitPE.event.player;

import net.BukkitPE.Player;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.level.Position;

public class PlayerRespawnEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    private Position position;

    public PlayerRespawnEvent(Player player, Position position) {
        this.player = player;
        this.position = position;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public Position getRespawnPosition() {
        return position;
    }

    public void setRespawnPosition(Position position) {
        this.position = position;
    }
}
