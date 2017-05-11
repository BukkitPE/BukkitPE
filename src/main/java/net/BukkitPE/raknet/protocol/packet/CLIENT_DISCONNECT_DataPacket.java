package net.BukkitPE.raknet.protocol.packet;

import net.BukkitPE.raknet.protocol.Packet;

/**
 * BukkitPE Project
 */
public class CLIENT_DISCONNECT_DataPacket extends Packet {
    public static final byte ID = (byte) 0x15;

    @Override
    public byte getID() {
        return ID;
    }

    public static final class Factory implements Packet.PacketFactory {

        @Override
        public Packet create() {
            return new CLIENT_DISCONNECT_DataPacket();
        }

    }
}
