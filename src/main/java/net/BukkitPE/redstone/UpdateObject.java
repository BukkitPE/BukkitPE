package net.BukkitPE.redstone;

import net.BukkitPE.block.Block;

/**
 * author: Angelic47
 * BukkitPE Project
 */
public class UpdateObject {

    private final int population;
    private Block location = null;

    public UpdateObject(int blockPopulation, Block blockLocation) {
        population = blockPopulation;
        location = blockLocation;
    }

    public int getPopulation() {
        return population;
    }

    public Block getLocation() {
        return location;
    }

}
