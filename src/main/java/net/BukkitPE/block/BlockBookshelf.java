package net.BukkitPE.block;

import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemTool;
import net.BukkitPE.utils.BlockColor;

/**
 * @author BukkitPE Project Team
 */
public class BlockBookshelf extends BlockSolid {

    public BlockBookshelf(int meta) {
        super(meta);
    }

    public BlockBookshelf() {
        this(0);
    }

    @Override
    public String getName() {
        return "Bookshelf";
    }

    @Override
    public int getId() {
        return BOOKSHELF;
    }

    @Override
    public double getHardness() {
        return 1.5D;
    }

    @Override
    public double getResistance() {
        return 7.5D;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_AXE;
    }

    @Override
    public int getBurnChance() {
        return 30;
    }

    @Override
    public int getBurnAbility() {
        return 20;
    }

    @Override
    public int[][] getDrops(Item item) {
        return new int[][]{
                {Item.BOOK, 0, 3}
        };
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.WOOD_BLOCK_COLOR;
    }

}
