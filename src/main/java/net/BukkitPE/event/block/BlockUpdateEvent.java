package net.BukkitPE.event.block;

import net.BukkitPE.block.Block;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

/**
 * BukkitPE Project
 */
public class BlockUpdateEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public BlockUpdateEvent(Block block) {
        super(block);
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

}
