package net.BukkitPE.inventory;

import net.BukkitPE.Player;
import net.BukkitPE.item.Item;
import net.BukkitPE.math.Vector3;
import net.BukkitPE.network.protocol.ContainerClosePacket;
import net.BukkitPE.network.protocol.ContainerOpenPacket;

import java.util.Map;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public abstract class ContainerInventory extends BaseInventory {
    public ContainerInventory(InventoryHolder holder, InventoryType type) {
        super(holder, type);
    }

    public ContainerInventory(InventoryHolder holder, InventoryType type, Map<Integer, Item> items) {
        super(holder, type, items);
    }

    public ContainerInventory(InventoryHolder holder, InventoryType type, Map<Integer, Item> items, Integer overrideSize) {
        super(holder, type, items, overrideSize);
    }

    public ContainerInventory(InventoryHolder holder, InventoryType type, Map<Integer, Item> items, Integer overrideSize, String overrideTitle) {
        super(holder, type, items, overrideSize, overrideTitle);
    }

    @Override
    public void onOpen(Player who) {
        super.onOpen(who);
        ContainerOpenPacket pk = new ContainerOpenPacket();
        pk.windowid = (byte) who.getWindowId(this);
        pk.type = (byte) this.getType().getNetworkType();
        pk.slots = this.getSize();
        InventoryHolder holder = this.getHolder();
        if (holder instanceof Vector3) {
            pk.x = (int) ((Vector3) holder).getX();
            pk.y = (int) ((Vector3) holder).getY();
            pk.z = (int) ((Vector3) holder).getZ();
        } else {
            pk.x = pk.y = pk.z = 0;
        }

        who.dataPacket(pk);

        this.sendContents(who);
    }

    @Override
    public void onClose(Player who) {
        ContainerClosePacket pk = new ContainerClosePacket();
        pk.windowid = (byte) who.getWindowId(this);
        who.dataPacket(pk);
        super.onClose(who);
    }
}
