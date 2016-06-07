package net.BukkitPE.event.level;

import net.BukkitPE.event.Event;
import net.BukkitPE.level.Level;

/**
 * author: funcraft
 * BukkitPE Project
 */
public abstract class WeatherEvent extends Event {

    private Level level;

    public WeatherEvent(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }
}
