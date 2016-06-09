package net.BukkitPE.level.generator.biome;

import net.BukkitPE.block.Block;
import net.BukkitPE.block.BlockDirt;

/**
 * author: Angelic47
 * BukkitPE Project
 */
public abstract class WateryBiome extends NormalBiome {
    public WateryBiome() {
        this.setGroundCover(new Block[]{
                new BlockDirt(),
                new BlockDirt(),
                new BlockDirt(),
                new BlockDirt(),
                new BlockDirt()
        });
    }
}
