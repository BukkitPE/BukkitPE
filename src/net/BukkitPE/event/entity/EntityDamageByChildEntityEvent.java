package net.BukkitPE.event.entity;

import net.BukkitPE.entity.Entity;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class EntityDamageByChildEntityEvent extends EntityDamageByEntityEvent {

    private Entity childEntity;

    public EntityDamageByChildEntityEvent(Entity damager, Entity childEntity, Entity entity, int cause, float damage) {
        super(damager, entity, cause, damage);
        this.childEntity = childEntity;
    }

    public Entity getChild() {
        return childEntity;
    }
}
