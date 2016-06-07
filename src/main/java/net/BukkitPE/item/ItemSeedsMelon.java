package net.BukkitPE.item;

import net.BukkitPE.block.BlockStemMelon;

/**

 * BukkitPE Project
 */
public class ItemSeedsMelon extends Item {

    public ItemSeedsMelon() {
        this(0, 1);
    }

    public ItemSeedsMelon(Integer meta) {
        this(meta, 1);
    }

    public ItemSeedsMelon(Integer meta, int count) {
        super(MELON_SEEDS, 0, count, "Melon Seeds");
        this.block = new BlockStemMelon();
    }
}
