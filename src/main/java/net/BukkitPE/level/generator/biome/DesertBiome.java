package net.BukkitPE.level.generator.biome;

/**

 * BukkitPE Project
 */
public class DesertBiome extends SandyBiome {
    public DesertBiome() {
        super();
        this.setElevation(63, 74);
        this.temperature = 2;
        this.rainfall = 0;
    }

    @Override
    public String getName() {
        return "Desert";
    }
}
