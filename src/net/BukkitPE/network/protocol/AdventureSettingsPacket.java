package net.BukkitPE.network.protocol;

/**
 * @author BukkitPE Project Team
 */
public class AdventureSettingsPacket extends DataPacket {

    public static final byte NETWORK_ID = ProtocolInfo.ADVENTURE_SETTINGS_PACKET;

    public int flags;

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        reset();
        putInt(flags);
    }

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

}
