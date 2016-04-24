package net.BukkitPE.event.level;

import net.BukkitPE.event.HandlerList;
import net.BukkitPE.level.Level;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class LevelSaveEvent extends LevelEvent {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    public LevelSaveEvent(Level level) {
        super(level);
    }

}
