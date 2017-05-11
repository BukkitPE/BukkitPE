package net.BukkitPE.inventory;

import net.BukkitPE.item.Item;

import java.util.UUID;

/**
 * BukkitPE Project
 */
public interface Recipe {

    Item getResult();

    void registerToCraftingManager();

    UUID getId();

    void setId(UUID id);
}
