package net.BukkitPE.event.entity;

import net.BukkitPE.entity.item.EntityItem;
import net.BukkitPE.event.HandlerList;

/**
 * BukkitPE Project
 */
public class ItemSpawnEvent extends EntityEvent {
    private static final HandlerList handlers = new HandlerList();

    public ItemSpawnEvent(EntityItem item) {
        this.entity = item;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    @Override
    public EntityItem getEntity() {
        return (EntityItem) this.entity;
    }
}
