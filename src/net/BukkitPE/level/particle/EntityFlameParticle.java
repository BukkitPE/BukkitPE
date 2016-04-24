package net.BukkitPE.level.particle;

import net.BukkitPE.math.Vector3;

/**
 * Created on 2015/11/21 by xtypr.
 * Package net.BukkitPE.level.particle in project BukkitPE .
 */
public class EntityFlameParticle extends GenericParticle {
    public EntityFlameParticle(Vector3 pos) {
        super(pos, Particle.TYPE_MOB_FLAME);
    }
}
