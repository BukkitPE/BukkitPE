package net.BukkitPE.event.block;

import net.BukkitPE.block.Block;
import net.BukkitPE.event.Event;

/**
 * BukkitPE Project
 */
public abstract class BlockEvent extends Event {

    protected final Block block;

    public BlockEvent(Block block) {
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }
}
