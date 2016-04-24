package net.BukkitPE.event.block;

import net.BukkitPE.block.Block;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class BlockGrowEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private Block newState;

    public BlockGrowEvent(Block block, Block newState) {
        super(block);
        this.newState = newState;
    }

    public Block getNewState() {
        return newState;
    }

}
