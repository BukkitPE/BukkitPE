package net.BukkitPE.event.inventory;

import net.BukkitPE.Player;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.inventory.Inventory;

/**
 * author: Box
 * BukkitPE Project
 */
public class InventoryCloseEvent extends InventoryEvent {

    private static final HandlerList handlers = new HandlerList();
    private final Player who;

    public InventoryCloseEvent(Inventory inventory, Player who) {
        super(inventory);
        this.who = who;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public Player getPlayer() {
        return this.who;
    }
}
