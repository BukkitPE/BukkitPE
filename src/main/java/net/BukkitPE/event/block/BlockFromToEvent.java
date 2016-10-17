package net.BukkitPE.event.block;

import net.BukkitPE.block.Block;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

public class BlockFromToEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private final Block to;

    public BlockFromToEvent(Block block, Block to) {
        super(block);
        this.to = to;
    }

    public Block getTo() {
        return to;
    }
}