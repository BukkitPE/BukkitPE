package net.BukkitPE.network.protocol;

public class TransferPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.TRANSFER_PACKET;
    public String address;
    public int port = 19132;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    @Override
    public void decode() {
        this.address = this.getString();
        this.port = this.getLShort();
    }

    @Override
    public void encode() {
        this.reset();
        this.putString(address);
        this.putLShort(port);
    }
}
