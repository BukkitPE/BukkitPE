package net.BukkitPE.event.level;

import net.BukkitPE.event.HandlerList;
import net.BukkitPE.level.format.FullChunk;

/**
 * BukkitPE Project
 */
public class ChunkPopulateEvent extends ChunkEvent {

    private static final HandlerList handlers = new HandlerList();

    public ChunkPopulateEvent(FullChunk chunk) {
        super(chunk);
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

}