package net.BukkitPE.level.particle;

import net.BukkitPE.math.Vector3;
import net.BukkitPE.network.protocol.DataPacket;
import net.BukkitPE.network.protocol.LevelEventPacket;

/**
 * Created on 2015/11/21 by xtypr.
 * Package net.BukkitPE.level.particle in project BukkitPE .
 */
public class GenericParticle extends Particle {

    protected final int data;
    protected int id = 0;

    public GenericParticle(Vector3 pos, int id) {
        this(pos, id, 0);
    }

    public GenericParticle(Vector3 pos, int id, int data) {
        super(pos.x, pos.y, pos.z);
        this.id = id;
        this.data = data;
    }

    @Override
    public DataPacket[] encode() {
        LevelEventPacket pk = new LevelEventPacket();
        pk.evid = (short) (LevelEventPacket.EVENT_ADD_PARTICLE_MASK | this.id);
        pk.x = (float) this.x;
        pk.y = (float) this.y;
        pk.z = (float) this.z;
        pk.data = this.data;

        return new DataPacket[]{pk};
    }
}
