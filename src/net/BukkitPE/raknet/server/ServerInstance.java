package net.BukkitPE.raknet.server;

import net.BukkitPE.raknet.protocol.EncapsulatedPacket;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public interface ServerInstance {

    void openSession(String identifier, String address, int port, long clientID);

    void closeSession(String identifier, String reason);

    void handleEncapsulated(String identifier, EncapsulatedPacket packet, int flags);

    void handleRaw(String address, int port, byte[] payload);

    void notifyACK(String identifier, int identifierACK);

    void handleOption(String option, String value);
}
