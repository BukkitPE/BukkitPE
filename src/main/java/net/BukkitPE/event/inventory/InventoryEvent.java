package net.BukkitPE.event.inventory;

import net.BukkitPE.Player;
import net.BukkitPE.event.Event;
import net.BukkitPE.inventory.Inventory;

/**

 * BukkitPE Project
 */
public abstract class InventoryEvent extends Event {

    protected final Inventory inventory;

    public InventoryEvent(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Player[] getViewers() {
        return this.inventory.getViewers().stream().toArray(Player[]::new);
    }

}
