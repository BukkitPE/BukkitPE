package net.BukkitPE.level.generator.object.tree;

import net.BukkitPE.level.ChunkManager;
import net.BukkitPE.math.NukkitRandom;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class ObjectTallBirchTree extends ObjectBirchTree {

    @Override
    public void placeObject(ChunkManager level, int x, int y, int z, NukkitRandom random) {
        this.treeHeight = random.nextBoundedInt(3) + 10;
        super.placeObject(level, x, y, z, random);
    }
}
