package net.BukkitPE.event.entity;

import net.BukkitPE.entity.item.EntityItem;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

/**

 * BukkitPE Project
 */
public class ItemDespawnEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    public ItemDespawnEvent(EntityItem item) {
        this.entity = item;
    }

    @Override
    public EntityItem getEntity() {
        return (EntityItem) this.entity;
    }
}
