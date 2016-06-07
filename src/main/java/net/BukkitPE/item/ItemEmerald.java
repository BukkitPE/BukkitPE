package net.BukkitPE.item;

/**

 * BukkitPE Project
 */
public class ItemEmerald extends Item {

    public ItemEmerald() {
        this(0, 1);
    }

    public ItemEmerald(Integer meta) {
        this(meta, 1);
    }

    public ItemEmerald(Integer meta, int count) {
        super(EMERALD, meta, count, "Emerald");
    }
}
