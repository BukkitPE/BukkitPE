package net.BukkitPE.event.level;

import net.BukkitPE.event.HandlerList;
import net.BukkitPE.level.Level;

/**
 * BukkitPE Project
 */
public class LevelSaveEvent extends LevelEvent {

    private static final HandlerList handlers = new HandlerList();

    public LevelSaveEvent(Level level) {
        super(level);
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

}
