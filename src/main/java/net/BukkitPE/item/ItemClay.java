package net.BukkitPE.item;

/**

 * BukkitPE Project
 */
public class ItemClay extends Item {

    public ItemClay() {
        this(0, 1);
    }

    public ItemClay(Integer meta) {
        this(meta, 1);
    }

    public ItemClay(Integer meta, int count) {
        super(CLAY, meta, count, "Clay");
    }
}
