package net.BukkitPE.level.generator.object.tree;

import net.BukkitPE.level.ChunkManager;
import net.BukkitPE.math.BukkitPERandom;

/**
 * BukkitPE Project
 */
public class ObjectTallBirchTree extends ObjectBirchTree {

    @Override
    public void placeObject(ChunkManager level, int x, int y, int z, BukkitPERandom random) {
        this.treeHeight = random.nextBoundedInt(3) + 10;
        super.placeObject(level, x, y, z, random);
    }
}
