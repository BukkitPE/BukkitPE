package net.BukkitPE.event.entity;

import net.BukkitPE.block.Block;
import net.BukkitPE.entity.Entity;

/**
 * BukkitPE Project
 */
public class EntityDamageByBlockEvent extends EntityDamageEvent {

    private final Block damager;

    public EntityDamageByBlockEvent(Block damager, Entity entity, int cause, float damage) {
        super(entity, cause, damage);
        this.damager = damager;
    }

    public Block getDamager() {
        return damager;
    }

}
