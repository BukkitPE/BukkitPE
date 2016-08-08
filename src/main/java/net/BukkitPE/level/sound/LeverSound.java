package net.BukkitPE.level.sound;

import net.BukkitPE.math.Vector3;
import net.BukkitPE.network.protocol.LevelEventPacket;

/**

 * BukkitPE Project
 */
public class LeverSound extends GenericSound {

    public LeverSound(Vector3 pos, boolean isPowerOn) {
        super(pos, LevelEventPacket.EVENT_SOUND_BUTTON_CLICK, isPowerOn ? 0.7f : 0.5f);
    }

}
