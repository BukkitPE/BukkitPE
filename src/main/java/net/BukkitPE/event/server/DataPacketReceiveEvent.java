package net.BukkitPE.event.server;

import net.BukkitPE.Player;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.network.protocol.DataPacket;

/**
 * BukkitPE Project
 */
public class DataPacketReceiveEvent extends ServerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final DataPacket packet;
    private final Player player;

    public DataPacketReceiveEvent(Player player, DataPacket packet) {
        this.packet = packet;
        this.player = player;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public DataPacket getPacket() {
        return packet;
    }

    public Player getPlayer() {
        return player;
    }
}
