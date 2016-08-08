package net.BukkitPE.raknet.protocol.packet;

import net.BukkitPE.raknet.protocol.DataPacket;
import net.BukkitPE.raknet.protocol.Packet;

/**

 * BukkitPE Project
 */
public class DATA_PACKET_8 extends DataPacket {
    public static final byte ID = (byte) 0x88;

    @Override
    public byte getID() {
        return ID;
    }

    public static final class Factory implements Packet.PacketFactory {

        @Override
        public Packet create() {
            return new DATA_PACKET_8();
        }

    }

}
