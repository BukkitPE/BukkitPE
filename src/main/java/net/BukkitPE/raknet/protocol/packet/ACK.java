package net.BukkitPE.raknet.protocol.packet;

import net.BukkitPE.raknet.protocol.AcknowledgePacket;
import net.BukkitPE.raknet.protocol.Packet;

/**
 * BukkitPE Project
 */
public class ACK extends AcknowledgePacket {

    public static final byte ID = (byte) 0xc0;

    @Override
    public byte getID() {
        return ID;
    }

    public static final class Factory implements Packet.PacketFactory {

        @Override
        public Packet create() {
            return new ACK();
        }

    }
}
