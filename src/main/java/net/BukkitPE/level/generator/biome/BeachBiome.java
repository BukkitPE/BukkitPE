package net.BukkitPE.level.generator.biome;

import net.BukkitPE.block.Block;
import net.BukkitPE.block.BlockSand;
import net.BukkitPE.block.BlockSandstone;

/**
 * Author: PeratX
 * BukkitPE Project
 */
public class BeachBiome extends SandyBiome {
    public BeachBiome() {
        //Todo: SugarCane

        this.setElevation(62, 65);
        this.temperature = 2;
        this.rainfall = 0;

        this.setGroundCover(new Block[]{
                new BlockSand(),
                new BlockSand(),
                new BlockSandstone(),
                new BlockSandstone(),
                new BlockSandstone()
        });
    }

    @Override
    public String getName() {
        return "Beach";
    }
}
