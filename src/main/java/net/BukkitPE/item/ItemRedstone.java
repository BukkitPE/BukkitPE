package net.BukkitPE.item;

import net.BukkitPE.block.BlockRedstoneWire;

/**
 * BukkitPE Project
 */
public class ItemRedstone extends Item {

    public ItemRedstone() {
        this(0, 1);
    }

    public ItemRedstone(Integer meta) {
        this(meta, 1);
    }

    public ItemRedstone(Integer meta, int count) {
        super(REDSTONE, meta, count, "Redstone");
        this.block = new BlockRedstoneWire();
    }

}
