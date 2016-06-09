package net.BukkitPE.event.level;

import net.BukkitPE.event.Event;
import net.BukkitPE.level.Level;

/**

 * BukkitPE Project
 */
public abstract class LevelEvent extends Event {

    private Level level;

    public LevelEvent(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }
}
