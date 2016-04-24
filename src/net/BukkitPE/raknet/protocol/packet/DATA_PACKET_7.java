package net.BukkitPE.raknet.protocol.packet;

import net.BukkitPE.raknet.protocol.DataPacket;
import net.BukkitPE.raknet.protocol.Packet;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class DATA_PACKET_7 extends DataPacket {
    public static byte ID = (byte) 0x87;

    @Override
    public byte getID() {
        return ID;
    }

    public static final class Factory implements Packet.PacketFactory {

        @Override
        public Packet create() {
            return new DATA_PACKET_7();
        }

    }

}
