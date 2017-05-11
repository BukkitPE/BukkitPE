package net.BukkitPE.event.level;

import net.BukkitPE.event.HandlerList;
import net.BukkitPE.level.format.FullChunk;

/**
 * BukkitPE Project
 */
public class ChunkLoadEvent extends ChunkEvent {

    private static final HandlerList handlers = new HandlerList();
    private final boolean newChunk;

    public ChunkLoadEvent(FullChunk chunk, boolean newChunk) {
        super(chunk);
        this.newChunk = newChunk;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public boolean isNewChunk() {
        return newChunk;
    }
}