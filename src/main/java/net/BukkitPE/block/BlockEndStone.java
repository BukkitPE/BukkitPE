package net.BukkitPE.block;

import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemTool;

/**
 * Created on 2015/12/1 by xtypr.
 * Package net.BukkitPE.block in project BukkitPE .
 */
public class BlockEndStone extends BlockSolid {

    public BlockEndStone() {
        this(0);
    }

    public BlockEndStone(int meta) {
        super(0);
    }

    @Override
    public String getName() {
        return "End Stone";
    }

    @Override
    public int getId() {
        return END_STONE;
    }

    @Override
    public double getHardness() {
        return 3;
    }

    @Override
    public double getResistance() {
        return 45;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public int[][] getDrops(Item item) {
        if (item.isPickaxe() && item.getTier() > ItemTool.TIER_WOODEN) {
            return new int[][]{{Item.END_STONE, 0, 1}};
        } else {
            return new int[0][];
        }
    }
}
