package net.BukkitPE.level.sound;

import net.BukkitPE.math.Vector3;
import net.BukkitPE.network.protocol.LevelEventPacket;

/**
 * Created by Pub4Game on 03.07.2016.
 */
public class ItemFramePlacedSound extends GenericSound {
    public ItemFramePlacedSound(Vector3 pos) {
        this(pos, 0);
    }

    public ItemFramePlacedSound(Vector3 pos, float pitch) {
        super(pos, LevelEventPacket.EVENT_SOUND_ITEM_FRAME_PLACED, pitch);
    }
}
