package net.BukkitPE.event.player;

import net.BukkitPE.Player;
import net.BukkitPE.block.Block;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

public class PlayerBedEnterEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Block bed;

    public PlayerBedEnterEvent(Player player, Block bed) {
        this.player = player;
        this.bed = bed;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public Block getBed() {
        return bed;
    }
}
