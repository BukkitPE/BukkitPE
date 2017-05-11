package net.BukkitPE.event.level;

import net.BukkitPE.event.HandlerList;
import net.BukkitPE.level.Level;

/**
 * BukkitPE Project
 */
public class LevelLoadEvent extends LevelEvent {

    private static final HandlerList handlers = new HandlerList();

    public LevelLoadEvent(Level level) {
        super(level);
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

}
