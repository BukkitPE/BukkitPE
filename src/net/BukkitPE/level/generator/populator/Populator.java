package net.BukkitPE.level.generator.populator;

import net.BukkitPE.level.ChunkManager;
import net.BukkitPE.math.NukkitRandom;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public abstract class Populator {
    public abstract void populate(ChunkManager level, int chunkX, int chunkZ, NukkitRandom random);
}
