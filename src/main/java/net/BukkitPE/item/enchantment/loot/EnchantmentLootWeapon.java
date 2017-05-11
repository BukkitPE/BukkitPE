package net.BukkitPE.item.enchantment.loot;

import net.BukkitPE.item.enchantment.Enchantment;
import net.BukkitPE.item.enchantment.EnchantmentType;

/**
 * BukkitPE Project
 */
public class EnchantmentLootWeapon extends EnchantmentLoot {
    public EnchantmentLootWeapon() {
        super(Enchantment.ID_LOOTING, "lootBonus", 2, EnchantmentType.WEAPON);
    }
}
