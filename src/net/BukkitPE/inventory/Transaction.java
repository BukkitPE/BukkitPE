package net.BukkitPE.inventory;

import net.BukkitPE.item.Item;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public interface Transaction {

    Inventory getInventory();

    int getSlot();

    Item getSourceItem();

    Item getTargetItem();

    long getCreationTime();
}
