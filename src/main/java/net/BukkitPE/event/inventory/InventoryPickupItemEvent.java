package net.BukkitPE.event.inventory;

import net.BukkitPE.entity.item.EntityItem;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.inventory.Inventory;

/**
 * BukkitPE Project
 */
public class InventoryPickupItemEvent extends InventoryEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final EntityItem item;

    public InventoryPickupItemEvent(Inventory inventory, EntityItem item) {
        super(inventory);
        this.item = item;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public EntityItem getItem() {
        return item;
    }
}