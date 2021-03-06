package net.BukkitPE.level.generator.populator;

import net.BukkitPE.block.Block;
import net.BukkitPE.level.ChunkManager;
import net.BukkitPE.level.format.FullChunk;
import net.BukkitPE.level.generator.Generator;
import net.BukkitPE.level.generator.biome.Biome;
import net.BukkitPE.level.generator.biome.WateryBiome;
import net.BukkitPE.level.generator.noise.Simplex;
import net.BukkitPE.math.BukkitPERandom;

/**
 * author: Angelic47
 * BukkitPE Project
 */
public class PopulatorCaves extends Populator {

    private Simplex cavesSimplex = null;

    public void initPopulate(BukkitPERandom random) {
        if (this.cavesSimplex != null) {
            return;
        }
        this.cavesSimplex = new Simplex(random, 4.1F, 15F, 1F / 200F);
        //实在太密啦啦啦
    }

    @Override
    public void populate(ChunkManager level, int chunkX, int chunkZ, BukkitPERandom random) {
        initPopulate(random);
        FullChunk chunk = level.getChunk(chunkX, chunkZ);
        double[][][] cavesGenerate = Generator.getFastNoise3D(this.cavesSimplex, 16, 128, 16, 4, 4, 4, chunkX * 16, 0, chunkZ * 16);
        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {

                Biome biome = Biome.getBiome(chunk.getBiomeId(x, z));
                Boolean hasWater = false;
                Boolean heightestBlock = true;
                if (biome instanceof WateryBiome) {
                    hasWater = true;
                    heightestBlock = false;
                }
                for (int y = 127; y >= 20; y--) {
                    if (chunk.getBlockId(x, y, z) == Block.AIR) {
                        continue;
                    }
                    if (chunk.getBlockId(x, y, z) == Block.WATER || chunk.getBlockId(x, y, z) == Block.STILL_WATER) {
                        hasWater = true;
                        heightestBlock = false;
                        continue;
                    }
                    if (hasWater) {
                        y -= 5;
                        hasWater = false;
                        continue;
                    }
                    if (cavesGenerate[x][z][y] > 0.35F) {
                        if (y > 20) {
                            chunk.setBlock(x, y, z, Block.AIR);
                            int highest = chunk.getHighestBlockAt(x, z);
                            /*int light = y < highest ? (highest - y < 10 ? highest - y : 1)  : 10;
                            chunk.setBlockSkyLight(x, y, z, light);
                            int bl = 0;
                            if (y < 25) {
                                bl = (25 - y) * 2;
                            }
                            chunk.setBlockLight(x, y, z, bl);*/
                        } else {
                            //LAVA
                            chunk.setBlock(x, y, z, Block.LAVA);
                            /*chunk.setBlockSkyLight(x, y, z, 0);
                            chunk.setBlockLight(x, y, z, 15);*/
                        }

                    } else if (heightestBlock) {
                        if (chunk.getBlockId(x, y, z) == Block.DIRT) {
                            chunk.setBlock(x, y, z, Block.GRASS);
                        }
                        heightestBlock = false;
                    }
                }

            }
        }
    }

}
