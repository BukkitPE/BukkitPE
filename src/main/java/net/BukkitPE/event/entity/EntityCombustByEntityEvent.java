package net.BukkitPE.event.entity;

import net.BukkitPE.entity.Entity;

/**

 * BukkitPE Project
 */
public class EntityCombustByEntityEvent extends EntityCombustEvent {

    protected Entity combuster;

    public EntityCombustByEntityEvent(Entity combuster, Entity combustee, int duration) {
        super(combustee, duration);
        this.combuster = combuster;
    }

    public Entity getCombuster() {
        return combuster;
    }
}
