package net.BukkitPE.item;

/**
 * BukkitPE Project
 */
public class ItemBootsDiamond extends ItemArmor {

    public ItemBootsDiamond() {
        this(0, 1);
    }

    public ItemBootsDiamond(Integer meta) {
        this(meta, 1);
    }

    public ItemBootsDiamond(Integer meta, int count) {
        super(DIAMOND_BOOTS, meta, count, "Diamond Boots");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_DIAMOND;
    }

    @Override
    public boolean isBoots() {
        return true;
    }
}
