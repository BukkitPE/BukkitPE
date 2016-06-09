package net.BukkitPE.event.player;

import net.BukkitPE.Player;
import net.BukkitPE.block.Block;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.item.Item;

public class PlayerBucketEmptyEvent extends PlayerBucketEvent {
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    public PlayerBucketEmptyEvent(Player who, Block blockClicked, Integer blockFace, Item bucket, Item itemInHand) {
        super(who, blockClicked, blockFace, bucket, itemInHand);
    }

}
