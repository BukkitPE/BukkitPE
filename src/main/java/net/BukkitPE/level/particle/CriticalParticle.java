package net.BukkitPE.level.particle;

import net.BukkitPE.math.Vector3;

/**
 * Created on 2015/11/21 by xtypr.
 * Package net.BukkitPE.level.particle in project BukkitPE .
 */
public class CriticalParticle extends GenericParticle {
    public CriticalParticle(Vector3 pos) {
        this(pos, 2);
    }

    public CriticalParticle(Vector3 pos, int scale) {
        super(pos, Particle.TYPE_CRITICAL, scale);
    }
}
