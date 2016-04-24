package net.BukkitPE.level.generator.biome;

import net.BukkitPE.block.Block;
import net.BukkitPE.block.BlockFlower;
import net.BukkitPE.block.BlockSapling;
import net.BukkitPE.level.generator.populator.PopulatorFlower;
import net.BukkitPE.level.generator.populator.PopulatorLilyPad;
import net.BukkitPE.level.generator.populator.PopulatorTree;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class SwampBiome extends GrassyBiome {

    public SwampBiome() {
        super();

        PopulatorLilyPad lilypad = new PopulatorLilyPad();
        lilypad.setBaseAmount(4);

        PopulatorTree trees = new PopulatorTree(BlockSapling.OAK);
        trees.setBaseAmount(2);

        PopulatorFlower flower = new PopulatorFlower();
        flower.setBaseAmount(2);
        flower.addType(Block.RED_FLOWER, BlockFlower.TYPE_BLUE_ORCHID);

        this.addPopulator(trees);
        this.addPopulator(flower);
        this.addPopulator(lilypad);

        this.setElevation(62, 63);

        this.temperature = 0.8;
        this.rainfall = 0.9;
    }

    @Override
    public String getName() {
        return "Swamp";
    }

    @Override
    public int getColor() {
        return 0x6a7039;
    }
}
