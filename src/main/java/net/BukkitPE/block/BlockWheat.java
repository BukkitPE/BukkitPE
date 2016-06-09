package net.BukkitPE.block;

import net.BukkitPE.item.Item;

/**
 * Created on 2015/12/2 by xtypr.
 * Package net.BukkitPE.block in project BukkitPE .
 */
public class BlockWheat extends BlockCrops {

    public BlockWheat() {
        this(0);
    }

    public BlockWheat(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Wheat Block";
    }

    @Override
    public int getId() {
        return WHEAT_BLOCK;
    }

    @Override
    public int[][] getDrops(Item item) {
        if (this.meta >= 0x07) {
            return new int[][]{
                    {Item.WHEAT, 0, 1},
                    {Item.WHEAT_SEEDS, 0, (int) (4d * Math.random())}
            };
        } else {
            return new int[][]{
                    {Item.WHEAT_SEEDS, 0, 1}
            };
        }
    }
}
