package net.BukkitPE.event.entity;

import net.BukkitPE.entity.Entity;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

/**
 * BukkitPE Project
 */
public class EntityCombustEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    protected int duration;

    public EntityCombustEvent(Entity combustee, int duration) {
        this.entity = combustee;
        this.duration = duration;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
