package net.BukkitPE.event.block;

import net.BukkitPE.block.Block;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

/**
 * BukkitPE Project
 */
public class BlockFormEvent extends BlockGrowEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public BlockFormEvent(Block block, Block newState) {
        super(block, newState);
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

}
