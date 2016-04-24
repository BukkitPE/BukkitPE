package net.BukkitPE.network;

import net.BukkitPE.raknet.protocol.EncapsulatedPacket;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class CacheEncapsulatedPacket extends EncapsulatedPacket {

    private byte[] internalData = null;

    @Override
    public byte[] toBinary() {
        return this.toBinary(false);
    }

    @Override
    public byte[] toBinary(boolean internal) {
        if (this.internalData == null) {
            this.internalData = super.toBinary(internal);
        }
        return this.internalData;
    }
}
