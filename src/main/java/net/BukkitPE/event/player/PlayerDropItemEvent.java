package net.BukkitPE.event.player;

import net.BukkitPE.Player;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.item.Item;

public class PlayerDropItemEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Item drop;

    public PlayerDropItemEvent(Player player, Item drop) {
        this.player = player;
        this.drop = drop;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public Item getItem() {
        return this.drop;
    }
}
