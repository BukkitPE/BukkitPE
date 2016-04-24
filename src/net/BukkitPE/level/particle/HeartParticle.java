package net.BukkitPE.level.particle;

import net.BukkitPE.math.Vector3;

/**
 * Created on 2015/11/21 by xtypr.
 * Package net.BukkitPE.level.particle in project BukkitPE .
 */
public class HeartParticle extends GenericParticle {
    public HeartParticle(Vector3 pos) {
        this(pos, 0);
    }

    public HeartParticle(Vector3 pos, int scale) {
        super(pos, Particle.TYPE_HEART, scale);
    }
}
