package net.BukkitPE.item;

/**

 * BukkitPE Project
 */
public class ItemDiamond extends Item {

    public ItemDiamond() {
        this(0, 1);
    }

    public ItemDiamond(Integer meta) {
        this(meta, 1);
    }

    public ItemDiamond(Integer meta, int count) {
        super(DIAMOND, 0, count, "Diamond");
    }
}
