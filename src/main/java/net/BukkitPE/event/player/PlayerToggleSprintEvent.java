package net.BukkitPE.event.player;

import net.BukkitPE.Player;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

public class PlayerToggleSprintEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    protected final boolean isSprinting;

    public PlayerToggleSprintEvent(Player player, boolean isSprinting) {
        this.player = player;
        this.isSprinting = isSprinting;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public boolean isSprinting() {
        return this.isSprinting;
    }

}
