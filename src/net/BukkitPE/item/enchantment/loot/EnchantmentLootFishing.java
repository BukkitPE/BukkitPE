package net.BukkitPE.item.enchantment.loot;

import net.BukkitPE.item.enchantment.Enchantment;
import net.BukkitPE.item.enchantment.EnchantmentType;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class EnchantmentLootFishing extends EnchantmentLoot {
    public EnchantmentLootFishing() {
        super(Enchantment.ID_FORTUNE_FISHING, "lootBonusFishing", 2, EnchantmentType.FISHING_ROD);
    }
}
