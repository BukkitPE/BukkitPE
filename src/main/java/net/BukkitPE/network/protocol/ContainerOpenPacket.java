package net.BukkitPE.network.protocol;

/**
 * BukkitPE Project
 */
public class ContainerOpenPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.CONTAINER_OPEN_PACKET;
    public final long entityId = -1;
    public byte windowid;
    public byte type;
    public int slots;
    public int x;
    public int y;
    public int z;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.putByte(this.windowid);
        this.putByte(this.type);
        this.putShort(this.slots);
        this.putInt(this.x);
        this.putInt(this.y);
        this.putInt(this.z);
        this.putLong(this.entityId);
    }
}
