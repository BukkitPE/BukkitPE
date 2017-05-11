package net.BukkitPE.level.generator.object.tree;

import net.BukkitPE.block.Block;
import net.BukkitPE.block.BlockWood;
import net.BukkitPE.level.ChunkManager;
import net.BukkitPE.math.BukkitPERandom;

/**
 * BukkitPE Project
 */
public class ObjectBirchTree extends ObjectTree {
    protected int treeHeight = 7;

    @Override
    public int getTrunkBlock() {
        return Block.LOG;
    }

    @Override
    public int getLeafBlock() {
        return Block.LEAVES;
    }

    @Override
    public int getType() {
        return BlockWood.BIRCH;
    }

    @Override
    public int getTreeHeight() {
        return this.treeHeight;
    }

    @Override
    public void placeObject(ChunkManager level, int x, int y, int z, BukkitPERandom random) {
        this.treeHeight = random.nextBoundedInt(3) + 5;
        super.placeObject(level, x, y, z, random);
    }
}
