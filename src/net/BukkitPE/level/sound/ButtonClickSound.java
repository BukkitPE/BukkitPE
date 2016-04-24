package net.BukkitPE.level.sound;

import net.BukkitPE.math.Vector3;
import net.BukkitPE.network.protocol.LevelEventPacket;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class ButtonClickSound extends GenericSound {
    public ButtonClickSound(Vector3 pos) {
        this(pos, 0);
    }

    public ButtonClickSound(Vector3 pos, float pitch) {
        super(pos, LevelEventPacket.EVENT_SOUND_BUTTON_CLICK, pitch);
    }
}
