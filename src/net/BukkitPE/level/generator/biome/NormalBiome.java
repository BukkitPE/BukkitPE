package net.BukkitPE.level.generator.biome;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public abstract class NormalBiome extends Biome {
    @Override
    public int getColor() {
        return this.grassColor;
    }
}
