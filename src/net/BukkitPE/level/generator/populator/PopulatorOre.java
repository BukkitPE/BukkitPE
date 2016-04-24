package net.BukkitPE.level.generator.populator;

import net.BukkitPE.level.ChunkManager;
import net.BukkitPE.level.generator.object.ore.ObjectOre;
import net.BukkitPE.level.generator.object.ore.OreType;
import net.BukkitPE.math.NukkitMath;
import net.BukkitPE.math.NukkitRandom;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class PopulatorOre extends Populator {
    private OreType[] oreTypes = new OreType[0];

    @Override
    public void populate(ChunkManager level, int chunkX, int chunkZ, NukkitRandom random) {
        for (OreType type : this.oreTypes) {
            ObjectOre ore = new ObjectOre(random, type);
            for (int i = 0; i < ore.type.clusterCount; ++i) {
                int x = NukkitMath.randomRange(random, chunkX << 4, (chunkX << 4) + 15);
                int y = NukkitMath.randomRange(random, ore.type.maxHeight, ore.type.maxHeight);
                int z = NukkitMath.randomRange(random, chunkZ << 4, (chunkZ << 4) + 15);
                if (ore.canPlaceObject(level, x, y, z)) {
                    ore.placeObject(level, x, y, z);
                }
            }
        }
    }

    public void setOreTypes(OreType[] oreTypes) {
        this.oreTypes = oreTypes;
    }
}
