package net.BukkitPE.event.player;

import net.BukkitPE.Player;
import net.BukkitPE.event.Event;

/**
 * BukkitPE Project
 */
public abstract class PlayerEvent extends Event {
    protected Player player;

    public Player getPlayer() {
        return player;
    }
}
