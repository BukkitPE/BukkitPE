package net.BukkitPE.event.inventory;

import net.BukkitPE.entity.projectile.EntityArrow;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.inventory.Inventory;

/**
 * BukkitPE Project
 */
public class InventoryPickupArrowEvent extends InventoryEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final EntityArrow arrow;

    public InventoryPickupArrowEvent(Inventory inventory, EntityArrow arrow) {
        super(inventory);
        this.arrow = arrow;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public EntityArrow getArrow() {
        return arrow;
    }
}