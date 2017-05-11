package net.BukkitPE.level.sound;

import net.BukkitPE.math.Vector3;
import net.BukkitPE.network.protocol.DataPacket;

/**
 * BukkitPE Project
 */
public abstract class Sound extends Vector3 {

    public Sound() {
        super(0, 0, 0);
    }

    public Sound(double x) {
        super(x, 0, 0);
    }

    public Sound(double x, double y) {
        super(x, y, 0);
    }

    public Sound(double x, double y, double z) {
        super(x, y, z);
    }

    abstract public DataPacket[] encode();
}
