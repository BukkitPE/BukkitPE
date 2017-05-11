package net.BukkitPE.item.enchantment;

import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemArmor;
import net.BukkitPE.item.ItemBow;
import net.BukkitPE.item.ItemFishingRod;

/**
 * BukkitPE Project
 */
public enum EnchantmentType {
    ALL,
    ARMOR,
    ARMOR_HEAD,
    ARMOR_TORSO,
    ARMOR_LEGS,
    ARMOR_FEET,
    WEAPON,
    DIGGER,
    FISHING_ROD,
    BREAKABLE,
    BOW;

    public boolean canEnchantItem(Item item) {
        if (this == ALL) {
            return true;

        } else if (this == BREAKABLE && item.getMaxDurability() >= 0) {
            return true;

        } else if (item instanceof ItemArmor) {
            if (this == ARMOR) {
                return true;
            }

            switch (this) {
                case ARMOR_HEAD:
                    return item.isHelmet();
                case ARMOR_TORSO:
                    return item.isChestplate();
                case ARMOR_LEGS:
                    return item.isLeggings();
                case ARMOR_FEET:
                    return item.isBoots();
                default:
                    return false;
            }

        } else {
            switch (this) {
                case WEAPON:
                    return item.isSword();
                case DIGGER:
                    return item.isTool();
                case BOW:
                    return item instanceof ItemBow;
                case FISHING_ROD:
                    return item instanceof ItemFishingRod;
                default:
                    return false;
            }
        }
    }
}
