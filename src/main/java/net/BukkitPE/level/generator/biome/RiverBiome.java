package net.BukkitPE.level.generator.biome;

import net.BukkitPE.level.generator.populator.PopulatorGrass;
import net.BukkitPE.level.generator.populator.PopulatorSugarcane;
import net.BukkitPE.level.generator.populator.PopulatorTallGrass;
import net.BukkitPE.level.generator.populator.PopulatorTallSugarcane;

/**

 * BukkitPE Project
 */
public class RiverBiome extends WateryBiome {

    public RiverBiome() {
        super();

        PopulatorSugarcane sugarcane = new PopulatorSugarcane();
        sugarcane.setBaseAmount(6);
        PopulatorTallSugarcane tallSugarcane = new PopulatorTallSugarcane();
        tallSugarcane.setBaseAmount(60);

        PopulatorGrass grass = new PopulatorGrass();
        grass.setBaseAmount(30);
        this.addPopulator(grass);

        PopulatorTallGrass tallGrass = new PopulatorTallGrass();
        tallGrass.setBaseAmount(5);

        this.addPopulator(tallGrass);
        this.addPopulator(sugarcane);
        this.addPopulator(tallSugarcane);

        this.setElevation(58, 62);

        this.temperature = 0.5;
        this.rainfall = 0.7;
    }

    @Override
    public String getName() {
        return "River";
    }
}
