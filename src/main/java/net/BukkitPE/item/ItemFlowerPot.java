package net.BukkitPE.item;

import net.BukkitPE.block.Block;

/**
 * Created by Snake1999 on 2016/2/4.
 * Package net.BukkitPE.item in project BukkitPE.
 */
public class ItemFlowerPot extends Item {

    public ItemFlowerPot() {
        this(0, 1);
    }

    public ItemFlowerPot(Integer meta) {
        this(meta, 1);
    }

    public ItemFlowerPot(Integer meta, int count) {
        super(FLOWER_POT, meta, count, "Flower Pot");
        this.block = Block.get(Block.FLOWER_POT_BLOCK);
    }

}
