package net.BukkitPE.inventory;

import net.BukkitPE.item.Item;

/**

 * BukkitPE Project
 */
public interface Transaction {

    Inventory getInventory();

    int getSlot();

    Item getSourceItem();

    Item getTargetItem();

    long getCreationTime();
}
