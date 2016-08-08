package net.BukkitPE.block;

import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemTool;
import net.BukkitPE.math.BukkitPERandom;

/**
 * Created on 2015/12/26 by xtypr.
 * Package net.BukkitPE.block in project BukkitPE .
 */
public class BlockOreQuartz extends BlockSolid {

    public BlockOreQuartz() {
        this(0);
    }

    public BlockOreQuartz(int meta) {
        super(0);
    }

    @Override
    public String getName() {
        return "Quartz Ore";
    }

    @Override
    public int getId() {
        return QUARTZ_ORE;
    }

    @Override
    public double getHardness() {
        return 3;
    }

    @Override
    public double getResistance() {
        return 5;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public int[][] getDrops(Item item) {
        if (item.isPickaxe() && item.getTier() >= ItemTool.TIER_WOODEN) {
            return new int[][]{
                    {Item.QUARTZ, 0, 1}
            };
        } else {
            return new int[0][0];
        }
    }

    @Override
    public int getDropExp() {
        return new BukkitPERandom().nextRange(1, 5);
    }
}
