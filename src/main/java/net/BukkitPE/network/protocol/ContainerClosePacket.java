package net.BukkitPE.network.protocol;

/**
 * BukkitPE Project
 */
public class ContainerClosePacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.CONTAINER_CLOSE_PACKET;
    public int windowid;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    @Override
    public void decode() {
        this.windowid = this.getByte();
    }

    @Override
    public void encode() {
        this.reset();
        this.putByte((byte) this.windowid);
    }
}
