package net.BukkitPE.level.generator.biome;

import net.BukkitPE.block.Block;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class OceanBiome extends WateryBiome {

    public OceanBiome() {
        super();

        this.setElevation(46, 58);

        this.temperature = 0.5;
        this.rainfall = 0.5;

    }

    @Override
    public Block[] getGroundCover() {
        return super.getGroundCover();
    }

    @Override
    public String getName() {
        return "Ocean";
    }
}
