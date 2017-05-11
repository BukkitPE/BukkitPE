package net.BukkitPE.network.protocol;

import net.BukkitPE.raknet.protocol.EncapsulatedPacket;
import net.BukkitPE.utils.BinaryStream;

/**
 * BukkitPE Project
 */
public abstract class DataPacket extends BinaryStream implements Cloneable {

    public boolean isEncoded = false;
    public EncapsulatedPacket encapsulatedPacket;
    public byte reliability;
    public Integer orderIndex = null;
    public Integer orderChannel = null;
    private int channel = 0;

    public abstract byte pid();

    public abstract void decode();

    public abstract void encode();

    @Override
    public void reset() {
        super.reset();
        this.putByte(this.pid());
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public DataPacket clean() {
        this.setBuffer(null);

        this.isEncoded = false;
        this.offset = 0;
        return this;
    }

    @Override
    public DataPacket clone() {
        try {
            return (DataPacket) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
