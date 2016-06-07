package net.BukkitPE.item.enchantment.damage;

import net.BukkitPE.entity.Entity;
import net.BukkitPE.entity.EntityArthropod;
import net.BukkitPE.entity.EntityLiving;
import net.BukkitPE.entity.EntitySmite;
import net.BukkitPE.item.Item;
import net.BukkitPE.item.enchantment.Enchantment;
import net.BukkitPE.item.enchantment.EnchantmentType;
import net.BukkitPE.potion.Effect;

import java.util.concurrent.ThreadLocalRandom;

/**

 * BukkitPE Project
 */
public abstract class EnchantmentDamage extends Enchantment {

    public enum TYPE {
        ALL,
        SMITE,
        ARTHROPODS
    }

    protected TYPE damageType;

    protected EnchantmentDamage(int id, String name, int weight, TYPE type) {
        super(id, name, weight, EnchantmentType.WEAPON);
        this.damageType = type;
    }

    @Override
    public double getDamageBonus(Entity entity) {
        int level = this.level;
        switch (this.damageType) {
            case ARTHROPODS:
                if (entity instanceof EntityArthropod) {
                    return (double) level * 2.5;
                }
            case SMITE:
                if (entity instanceof EntitySmite) {
                    return (double) level * 2.5;
                }
            case ALL:
                return (double) level * 1.25;
        }

        return 0;
    }

    @Override
    public boolean isCompatibleWith(Enchantment enchantment) {
        return !(enchantment instanceof EnchantmentDamage);
    }

    @Override
    public boolean canEnchant(Item item) {
        return item.isAxe() || super.canEnchant(item);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public void doPostAttack(Entity attacker, Entity entity) {
        if (attacker instanceof EntityLiving) {
            if (this.damageType == TYPE.ARTHROPODS && entity instanceof EntityArthropod) {
                int duration = 20 + ThreadLocalRandom.current().nextInt(10 * this.level);
                entity.addEffect(Effect.getEffect(Effect.SLOWNESS).setDuration(duration).setAmplifier(3));
            }
        }
    }

    @Override
    public String getName() {
        return "%enchantment.damage." + this.name;
    }
}
