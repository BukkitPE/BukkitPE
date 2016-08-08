package net.BukkitPE.block;

import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemDye;
import net.BukkitPE.item.ItemTool;
import net.BukkitPE.utils.BlockColor;

/**
 * Created on 2015/12/2 by xtypr.
 * Package net.BukkitPE.block in project BukkitPE .
 */
public class BlockClayStained extends BlockSolid {

    public BlockClayStained() {
        this(0);
    }

    public BlockClayStained(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return ItemDye.getColorName(meta) + " Stained Clay";
    }

    @Override
    public int getId() {
        return STAINED_CLAY;
    }

    @Override
    public double getHardness() {
        return 1.25;
    }

    @Override
    public double getResistance() {
        return 0.75;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public int[][] getDrops(Item item) {
        if (item.isPickaxe() && item.getTier() >= ItemTool.TIER_WOODEN) {
            return new int[][]{{Item.STAINED_CLAY, this.meta, 1}};
        } else {
            return new int[0][0];
        }
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.getDyeColor(meta);
    }

}
