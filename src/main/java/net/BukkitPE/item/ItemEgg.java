package net.BukkitPE.item;

/**
 * BukkitPE Project
 */
public class ItemEgg extends Item {

    public ItemEgg() {
        this(0, 1);
    }

    public ItemEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemEgg(Integer meta, int count) {
        super(EGG, meta, count, "Egg");
    }
}
