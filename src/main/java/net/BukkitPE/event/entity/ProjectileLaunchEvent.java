package net.BukkitPE.event.entity;

import net.BukkitPE.entity.projectile.EntityProjectile;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

public class ProjectileLaunchEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public ProjectileLaunchEvent(EntityProjectile entity) {
        this.entity = entity;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public EntityProjectile getEntity() {
        return (EntityProjectile) this.entity;
    }
}
