package net.BukkitPE.event.player;

import net.BukkitPE.Player;
import net.BukkitPE.block.Block;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.item.Item;

public class PlayerBucketFillEvent extends PlayerBucketEvent {
    private static final HandlerList handlers = new HandlerList();

    public PlayerBucketFillEvent(Player who, Block blockClicked, int blockFace, Item bucket, Item itemInHand) {
        super(who, blockClicked, blockFace, bucket, itemInHand);
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

}
