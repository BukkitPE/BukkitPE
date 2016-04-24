package net.BukkitPE.event.entity;

import net.BukkitPE.entity.item.EntityItem;
import net.BukkitPE.event.HandlerList;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class ItemSpawnEvent extends EntityEvent {
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    public ItemSpawnEvent(EntityItem item) {
        this.entity = item;
    }

    @Override
    public EntityItem getEntity() {
        return (EntityItem) this.entity;
    }
}
