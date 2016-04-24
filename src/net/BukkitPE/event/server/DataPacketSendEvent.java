package net.BukkitPE.event.server;

import net.BukkitPE.Player;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.network.protocol.DataPacket;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class DataPacketSendEvent extends ServerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private DataPacket packet;
    private Player player;

    public DataPacketSendEvent(Player player, DataPacket packet) {
        this.packet = packet;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public DataPacket getPacket() {
        return packet;
    }
}
