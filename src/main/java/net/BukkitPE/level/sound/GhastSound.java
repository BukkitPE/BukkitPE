package net.BukkitPE.level.sound;

import net.BukkitPE.math.Vector3;
import net.BukkitPE.network.protocol.LevelEventPacket;

/**
 * Created on 2015/11/21 by xtypr.
 * Package net.BukkitPE.level.sound in project BukkitPE .
 */
public class GhastSound extends GenericSound {
    public GhastSound(Vector3 pos) {
        this(pos, 0);
    }

    public GhastSound(Vector3 pos, float pitch) {
        super(pos, LevelEventPacket.EVENT_SOUND_GHAST, pitch);
    }
}
