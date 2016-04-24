package net.BukkitPE.level.generator.biome;

import net.BukkitPE.level.generator.populator.PopulatorGrass;
import net.BukkitPE.level.generator.populator.PopulatorTallGrass;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class RiverBiome extends WateryBiome {

    public RiverBiome() {
        super();

        PopulatorGrass grass = new PopulatorGrass();
        grass.setBaseAmount(30);
        this.addPopulator(grass);

        PopulatorTallGrass tallGrass = new PopulatorTallGrass();
        tallGrass.setBaseAmount(5);

        this.addPopulator(tallGrass);

        this.setElevation(58, 62);

        this.temperature = 0.5;
        this.rainfall = 0.7;
    }

    @Override
    public String getName() {
        return "River";
    }
}
