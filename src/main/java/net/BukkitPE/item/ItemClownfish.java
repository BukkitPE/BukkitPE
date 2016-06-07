package net.BukkitPE.item;

/**
 * Created by Snake1999 on 2016/1/14.
 * Package net.BukkitPE.item in project BukkitPE.
 */
public class ItemClownfish extends ItemFish {

    public ItemClownfish() {
        this(0, 1);
    }

    public ItemClownfish(Integer meta) {
        this(meta, 1);
    }

    public ItemClownfish(Integer meta, int count) {
        super(CLOWNFISH, meta, count, "Clownfish");
    }
}
