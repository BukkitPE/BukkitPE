package net.BukkitPE.event.block;

import net.BukkitPE.block.Block;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

/**
 * BukkitPE Project
 */
public class BlockSpreadEvent extends BlockFormEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Block source;

    public BlockSpreadEvent(Block block, Block source, Block newState) {
        super(block, newState);
        this.source = source;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public Block getSource() {
        return source;
    }
}
