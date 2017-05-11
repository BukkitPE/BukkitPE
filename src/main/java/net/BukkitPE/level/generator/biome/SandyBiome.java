package net.BukkitPE.level.generator.biome;

import net.BukkitPE.block.Block;
import net.BukkitPE.block.BlockSand;
import net.BukkitPE.block.BlockSandstone;
import net.BukkitPE.level.generator.populator.PopulatorCactus;
import net.BukkitPE.level.generator.populator.PopulatorDeadBush;

/**
 * BukkitPE Project
 */
public abstract class SandyBiome extends NormalBiome {
    public SandyBiome() {

        PopulatorCactus cactus = new PopulatorCactus();
        cactus.setBaseAmount(2);

        PopulatorDeadBush deadbush = new PopulatorDeadBush();
        deadbush.setBaseAmount(2);

        this.addPopulator(cactus);
        this.addPopulator(deadbush);

        this.setGroundCover(new Block[]{
                new BlockSand(),
                new BlockSand(),
                new BlockSandstone(),
                new BlockSandstone(),
                new BlockSandstone()
        });
    }
}
