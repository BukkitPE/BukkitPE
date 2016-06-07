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

    public static HandlerList getHandlers() {
        return handlers;
    }

    private Player who;

    public InventoryCloseEvent(Inventory inventory, Player who) {
        super(inventory);
        this.who = who;
    }

    public Player getPlayer() {
        return this.who;
    }
}
