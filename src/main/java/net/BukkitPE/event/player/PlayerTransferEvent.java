package net.BukkitPE.event.player;

import net.BukkitPE.Player;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

public class PlayerTransferEvent extends PlayerEvent implements Cancellable {
    public static final int ARM_SWING = 1;
    private static final HandlerList handlers = new HandlerList();
    private String address;
    private int port;

    public PlayerAnimationEvent(Player player, String address, int port) {
        this.player = player;
        this.address = address;
        this.port = port;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public String getAddress(){
        return address;
    }

    public int getPort(){
        return port;
    }
}
