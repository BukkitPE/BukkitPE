package net.BukkitPE.event.entity;

import net.BukkitPE.entity.Entity;
import net.BukkitPE.entity.projectile.EntityProjectile;
import net.BukkitPE.event.HandlerList;

/**

 * BukkitPE Project
 */
public class ProjectileHitEvent extends EntityEvent {
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    public ProjectileHitEvent(EntityProjectile entity) {
        this.entity = entity;
    }

    @Override
    public Entity getEntity() {
        return super.getEntity();
    }
}
