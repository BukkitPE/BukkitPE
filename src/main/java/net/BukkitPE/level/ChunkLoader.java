package net.BukkitPE.level;

import net.BukkitPE.level.format.FullChunk;
import net.BukkitPE.math.Vector3;

/**
 * BukkitPE Project
 */
public interface ChunkLoader {

    Integer getLoaderId();

    boolean isLoaderActive();

    Position getPosition();

    double getX();

    double getZ();

    Level getLevel();

    void onChunkChanged(FullChunk chunk);

    void onChunkLoaded(FullChunk chunk);

    void onChunkUnloaded(FullChunk chunk);

    void onChunkPopulated(FullChunk chunk);

    void onBlockChanged(Vector3 block);
}
