package net.BukkitPE.level.generator.biome;

import net.BukkitPE.block.Block;
import net.BukkitPE.block.BlockDirt;
import net.BukkitPE.block.BlockGrass;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public abstract class GrassyBiome extends NormalBiome {
    public GrassyBiome() {
        this.setGroundCover(new Block[]{
                new BlockGrass(),
                new BlockDirt(),
                new BlockDirt(),
                new BlockDirt(),
                new BlockDirt()
        });
    }
}
