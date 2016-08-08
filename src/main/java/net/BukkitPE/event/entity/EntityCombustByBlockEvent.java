package net.BukkitPE.event.entity;

import net.BukkitPE.block.Block;
import net.BukkitPE.entity.Entity;

/**
 * author: Box
 * BukkitPE Project
 */
public class EntityCombustByBlockEvent extends EntityCombustEvent {

    protected final Block combuster;

    public EntityCombustByBlockEvent(Block combuster, Entity combustee, int duration) {
        super(combustee, duration);
        this.combuster = combuster;
    }

    public Block getCombuster() {
        return combuster;
    }
}
