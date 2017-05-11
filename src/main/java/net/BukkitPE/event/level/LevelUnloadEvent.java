package net.BukkitPE.event.level;

import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.level.Level;

/**
 * BukkitPE Project
 */
public class LevelUnloadEvent extends LevelEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public LevelUnloadEvent(Level level) {
        super(level);
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

}
