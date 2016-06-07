package net.BukkitPE.event.weather;

import net.BukkitPE.entity.weather.EntityLightningStrike;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.level.Level;

/**
 * author: funcraft
 * BukkitPE Project
 */
public class LightningStrikeEvent extends WeatherEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final EntityLightningStrike bolt;

    public static HandlerList getHandlers() {
        return handlers;
    }

    public LightningStrikeEvent(Level level, final EntityLightningStrike bolt) {
        super(level);
        this.bolt = bolt;
    }

    /**
     * * Gets the bolt which is striking the earth.
     * * @return lightning entity
     */
    public EntityLightningStrike getLightning() {
        return bolt;
    }

}
