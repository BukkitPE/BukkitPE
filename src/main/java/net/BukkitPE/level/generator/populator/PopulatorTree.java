package net.BukkitPE.level.generator.populator;

import net.BukkitPE.block.Block;
import net.BukkitPE.block.BlockSapling;
import net.BukkitPE.level.ChunkManager;
import net.BukkitPE.level.generator.object.tree.ObjectTree;
import net.BukkitPE.math.BukkitPEMath;
import net.BukkitPE.math.BukkitPERandom;

/**

 * BukkitPE Project
 */
public class PopulatorTree extends Populator {
    private ChunkManager level;
    private int randomAmount;
    private int baseAmount;

    private final int type;

    public PopulatorTree() {
        this(BlockSapling.OAK);
    }

    public PopulatorTree(int type) {
        this.type = type;
    }

    public void setRandomAmount(int randomAmount) {
        this.randomAmount = randomAmount;
    }

    public void setBaseAmount(int baseAmount) {
        this.baseAmount = baseAmount;
    }

    @Override
    public void populate(ChunkManager level, int chunkX, int chunkZ, BukkitPERandom random) {
        this.level = level;
        int amount = random.nextBoundedInt(this.randomAmount + 1) + this.baseAmount;
        for (int i = 0; i < amount; ++i) {
            int x = BukkitPEMath.randomRange(random, chunkX << 4, (chunkX << 4) + 15);
            int z = BukkitPEMath.randomRange(random, chunkZ << 4, (chunkZ << 4) + 15);
            int y = this.getHighestWorkableBlock(x, z);
            if (y == -1) {
                continue;
            }
            ObjectTree.growTree(this.level, x, y, z, random, this.type);
        }
    }

    private int getHighestWorkableBlock(int x, int z) {
        int y;
        for (y = 127; y > 0; --y) {
            int b = this.level.getBlockIdAt(x, y, z);
            if (b == Block.DIRT || b == Block.GRASS) {
                break;
            } else if (b != Block.AIR && b != Block.SNOW_LAYER) {
                return -1;
            }
        }

        return ++y;
    }
}
