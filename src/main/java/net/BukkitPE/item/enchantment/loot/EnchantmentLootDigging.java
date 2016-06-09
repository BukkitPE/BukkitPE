package net.BukkitPE.item.enchantment.loot;

import net.BukkitPE.item.enchantment.Enchantment;
import net.BukkitPE.item.enchantment.EnchantmentType;

/**

 * BukkitPE Project
 */
public class EnchantmentLootDigging extends EnchantmentLoot {
    public EnchantmentLootDigging() {
        super(Enchantment.ID_FORTUNE_DIGGING, "lootBonusDigger", 2, EnchantmentType.DIGGER);
    }
}
