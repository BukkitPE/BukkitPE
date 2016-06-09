package net.BukkitPE.event.level;

import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.level.Level;

/**
 * author: funcraft
 * BukkitPE Project
 */
public class WeatherChangeEvent extends WeatherEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private boolean to;

    public static HandlerList getHandlers() {
        return handlers;
    }

    public WeatherChangeEvent(Level level, boolean to) {
        super(level);
        this.to = to;
    }

    /**
     * Gets the state of weather that the world is being set to
     *
     * @return true if the weather is being set to raining, false otherwise
     */
    public boolean toWeatherState() {
        return to;
    }

}
