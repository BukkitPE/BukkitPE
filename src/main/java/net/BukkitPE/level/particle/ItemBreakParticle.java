package net.BukkitPE.level.particle;

import net.BukkitPE.item.Item;
import net.BukkitPE.math.Vector3;

/**
 * Created on 2015/11/21 by xtypr.
 * Package net.BukkitPE.level.particle in project BukkitPE .
 */
public class ItemBreakParticle extends GenericParticle {
    public ItemBreakParticle(Vector3 pos, Item item) {
        super(pos, Particle.TYPE_ITEM_BREAK, (item.getId() << 16) | item.getDamage());
    }
}
