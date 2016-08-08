package net.BukkitPE.level.sound;

import net.BukkitPE.math.Vector3;
import net.BukkitPE.network.protocol.LevelEventPacket;

/**
 * Created by Pub4Game on 28.06.2016.
 */
public class ExperienceOrbSound extends GenericSound {
    public ExperienceOrbSound(Vector3 pos) {
        this(pos, 0);
    }

    public ExperienceOrbSound(Vector3 pos, float pitch) {
        super(pos, LevelEventPacket.EVENT_SOUND_EXPERIENCE_ORB, pitch);
    }
}
