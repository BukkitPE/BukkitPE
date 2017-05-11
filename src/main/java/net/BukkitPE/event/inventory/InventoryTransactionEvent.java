package net.BukkitPE.event.inventory;

import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.Event;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.inventory.TransactionGroup;

/**
 * BukkitPE Project
 */
public class InventoryTransactionEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final TransactionGroup transaction;

    public InventoryTransactionEvent(TransactionGroup transaction) {
        this.transaction = transaction;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public TransactionGroup getTransaction() {
        return transaction;
    }

}