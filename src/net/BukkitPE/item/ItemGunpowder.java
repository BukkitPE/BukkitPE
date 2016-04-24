package net.BukkitPE.item;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class ItemGunpowder extends Item {

    public ItemGunpowder() {
        this(0, 1);
    }

    public ItemGunpowder(Integer meta) {
        this(meta, 1);
    }

    public ItemGunpowder(Integer meta, int count) {
        super(GUNPOWDER, meta, count, "Gunpowder");
    }
}
