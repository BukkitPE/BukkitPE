package net.BukkitPE.inventory;

import net.BukkitPE.item.Item;

import java.util.UUID;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public interface Recipe {

    Item getResult();

    void registerToCraftingManager();

    UUID getId();

    void setId(UUID id);
}
