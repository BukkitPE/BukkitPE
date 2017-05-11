package net.BukkitPE.network.protocol;

import net.BukkitPE.item.Item;

/**
 * BukkitPE Project
 */
public class AddItemEntityPacket extends DataPacket {
    public static final byte NETWORK_ID = ProtocolInfo.ADD_ITEM_ENTITY_PACKET;
    public long eid;
    public Item item;
    public float x;
    public float y;
    public float z;
    public float speedX;
    public float speedY;
    public float speedZ;

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
        this.putLong(this.eid);
        this.putSlot(this.item);
        this.putFloat(this.x);
        this.putFloat(this.y);
        this.putFloat(this.z);
        this.putFloat(this.speedX);
        this.putFloat(this.speedY);
        this.putFloat(this.speedZ);
    }
}
