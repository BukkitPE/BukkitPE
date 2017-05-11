package net.BukkitPE.event.player;

import net.BukkitPE.Player;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.item.Item;

/**
 * BukkitPE Project
 */
public class PlayerItemHeldEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Item item;
    private final int slot;
    private final int inventorySlot;
    public PlayerItemHeldEvent(Player player, Item item, int inventorySlot, int slot) {
        this.player = player;
        this.item = item;
        this.inventorySlot = inventorySlot;
        this.slot = slot;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public int getSlot() {
        return slot;
    }

    public int getInventorySlot() {
        return inventorySlot;
    }

    public Item getItem() {
        return item;
    }

}
