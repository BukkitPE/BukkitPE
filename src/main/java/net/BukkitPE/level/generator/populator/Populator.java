package net.BukkitPE.level.generator.populator;

import net.BukkitPE.level.ChunkManager;
import net.BukkitPE.math.BukkitPERandom;

/**

 * BukkitPE Project
 */
public abstract class Populator {
    public abstract void populate(ChunkManager level, int chunkX, int chunkZ, BukkitPERandom random);
}
