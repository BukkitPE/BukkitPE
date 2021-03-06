package net.BukkitPE.item;

/**
 * BukkitPE Project
 */
public class ItemBootsGold extends ItemArmor {

    public ItemBootsGold() {
        this(0, 1);
    }

    public ItemBootsGold(Integer meta) {
        this(meta, 1);
    }

    public ItemBootsGold(Integer meta, int count) {
        super(GOLD_BOOTS, meta, count, "Gold Boots");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_GOLD;
    }

    @Override
    public boolean isBoots() {
        return true;
    }
}
