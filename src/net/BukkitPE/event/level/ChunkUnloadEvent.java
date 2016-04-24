package net.BukkitPE.event.level;

import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.level.format.FullChunk;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class ChunkUnloadEvent extends ChunkEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    public ChunkUnloadEvent(FullChunk chunk) {
        super(chunk);
    }

}