package net.BukkitPE.event.player;

import net.BukkitPE.Player;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.item.Item;

/**
 * Called when a player eats something
 */
public class PlayerItemConsumeEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Item item;

    public PlayerItemConsumeEvent(Player player, Item item) {
        this.player = player;
        this.item = item;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public Item getItem() {
        return this.item.clone();
    }
}
