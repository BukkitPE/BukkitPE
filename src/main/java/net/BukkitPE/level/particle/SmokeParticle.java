package net.BukkitPE.level.particle;

import net.BukkitPE.math.Vector3;

/**
 * Created on 2015/11/21 by xtypr.
 * Package net.BukkitPE.level.particle in project BukkitPE .
 */
public class SmokeParticle extends GenericParticle {
    public SmokeParticle(Vector3 pos) {
        this(pos, 0);
    }

    public SmokeParticle(Vector3 pos, int scale) {
        super(pos, Particle.TYPE_SMOKE, scale);
    }
}
