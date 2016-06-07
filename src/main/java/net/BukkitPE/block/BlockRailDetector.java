package net.BukkitPE.block;

import net.BukkitPE.item.Item;

/**
 * Created on 2015/11/22 by CreeperFace.
 * Package net.BukkitPE.block in project BukkitPE .
 */
public class BlockRailDetector extends BlockRail {
    public BlockRailDetector() {
        this(0);
    }

    public BlockRailDetector(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return DETECTOR_RAIL;
    }

    @Override
    public String getName() {
        return "Detector Rail";
    }

    @Override
    public int[][] getDrops(Item item) {
        return new int[][]{{Item.DETECTOR_RAIL, 0, 1}};
    }
}
