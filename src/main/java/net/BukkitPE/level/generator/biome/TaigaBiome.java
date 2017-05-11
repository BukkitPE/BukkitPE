package net.BukkitPE.level.generator.biome;

import net.BukkitPE.block.BlockSapling;
import net.BukkitPE.level.generator.populator.PopulatorGrass;
import net.BukkitPE.level.generator.populator.PopulatorTallGrass;
import net.BukkitPE.level.generator.populator.PopulatorTree;

/**
 * BukkitPE Project
 */
public class TaigaBiome extends SnowyBiome {

    public TaigaBiome() {
        super();

        PopulatorGrass grass = new PopulatorGrass();
        grass.setBaseAmount(6);
        this.addPopulator(grass);

        PopulatorTree trees = new PopulatorTree(BlockSapling.SPRUCE);
        trees.setBaseAmount(10);
        this.addPopulator(trees);

        PopulatorTallGrass tallGrass = new PopulatorTallGrass();
        tallGrass.setBaseAmount(1);

        this.addPopulator(tallGrass);

        this.setElevation(63, 81);

        this.temperature = 0.05;
        this.rainfall = 0.8;
    }

    @Override
    public String getName() {
        return "Taiga";
    }
}
