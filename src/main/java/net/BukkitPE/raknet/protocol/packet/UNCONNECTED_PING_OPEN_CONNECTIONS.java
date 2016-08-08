package net.BukkitPE.raknet.protocol.packet;

import net.BukkitPE.raknet.protocol.Packet;

/**

 * BukkitPE Project
 */
public class UNCONNECTED_PING_OPEN_CONNECTIONS extends UNCONNECTED_PING {
    public static final byte ID = (byte) 0x02;

    @Override
    public byte getID() {
        return ID;
    }

    public static final class Factory implements Packet.PacketFactory {

        @Override
        public Packet create() {
            return new UNCONNECTED_PING_OPEN_CONNECTIONS();
        }

    }
}
