package net.BukkitPE.item;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class ItemStick extends Item {

    public ItemStick() {
        this(0, 1);
    }

    public ItemStick(Integer meta) {
        this(meta, 1);
    }

    public ItemStick(Integer meta, int count) {
        super(STICK, 0, count, "Stick");
    }
}
