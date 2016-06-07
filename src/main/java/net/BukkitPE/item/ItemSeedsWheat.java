package net.BukkitPE.item;

import net.BukkitPE.block.BlockWheat;

/**

 * BukkitPE Project
 */
public class ItemSeedsWheat extends Item {

    public ItemSeedsWheat() {
        this(0, 1);
    }

    public ItemSeedsWheat(Integer meta) {
        this(meta, 1);
    }

    public ItemSeedsWheat(Integer meta, int count) {
        super(WHEAT_SEEDS, 0, count, "Wheat Seeds");
        this.block = new BlockWheat();
    }
}
