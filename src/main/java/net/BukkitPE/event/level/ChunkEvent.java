package net.BukkitPE.event.level;

import net.BukkitPE.level.format.FullChunk;

/**

 * BukkitPE Project
 */
public abstract class ChunkEvent extends LevelEvent {

    private FullChunk chunk;

    public ChunkEvent(FullChunk chunk) {
        super(chunk.getProvider().getLevel());
        this.chunk = chunk;
    }

    public FullChunk getChunk() {
        return chunk;
    }
}
