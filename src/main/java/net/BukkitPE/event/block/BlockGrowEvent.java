package net.BukkitPE.event.block;

import net.BukkitPE.block.Block;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

/**
 * BukkitPE Project
 */
public class BlockGrowEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Block newState;

    public BlockGrowEvent(Block block, Block newState) {
        super(block);
        this.newState = newState;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public Block getNewState() {
        return newState;
    }

}
