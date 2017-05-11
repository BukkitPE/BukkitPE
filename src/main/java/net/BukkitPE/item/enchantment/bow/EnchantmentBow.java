package net.BukkitPE.item.enchantment.bow;

import net.BukkitPE.item.enchantment.Enchantment;
import net.BukkitPE.item.enchantment.EnchantmentType;

/**
 * BukkitPE Project
 */
public abstract class EnchantmentBow extends Enchantment {
    protected EnchantmentBow(int id, String name, int weight) {
        super(id, name, weight, EnchantmentType.BOW);
    }

}
