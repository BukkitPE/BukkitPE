package net.BukkitPE.block;

import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemTool;
import net.BukkitPE.utils.BlockColor;

/**
 * Created on 2015/12/1 by xtypr.
 * Package net.BukkitPE.block in project BukkitPE .
 */
public class BlockEmerald extends BlockSolid {

    public BlockEmerald() {
        this(0);
    }

    public BlockEmerald(int meta) {
        super(0);
    }

    @Override
    public String getName() {
        return "Emerald Block";
    }

    @Override
    public int getId() {
        return EMERALD_BLOCK;
    }

    @Override
    public double getHardness() {
        return 5;
    }

    @Override
    public double getResistance() {
        return 30;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public int[][] getDrops(Item item) {
        if (item.isPickaxe()) {
            return new int[][]{
                    {Item.EMERALD_BLOCK, 0, 1}
            };
        } else {
            return new int[][]{};
        }
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.EMERALD_BLOCK_COLOR;
    }
}
