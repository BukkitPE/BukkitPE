package net.BukkitPE.item;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class ItemWheat extends Item {

    public ItemWheat() {
        this(0, 1);
    }

    public ItemWheat(Integer meta) {
        this(meta, 1);
    }

    public ItemWheat(Integer meta, int count) {
        super(WHEAT, meta, count, "Wheat");
    }
}
