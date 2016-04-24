package net.BukkitPE.item;

import net.BukkitPE.block.BlockCarrot;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class ItemCarrot extends ItemEdible {

    public ItemCarrot() {
        this(0, 1);
    }

    public ItemCarrot(Integer meta) {
        this(meta, 1);
    }

    public ItemCarrot(Integer meta, int count) {
        super(CARROT, 0, count, "Carrot");
        this.block = new BlockCarrot();
    }

}
