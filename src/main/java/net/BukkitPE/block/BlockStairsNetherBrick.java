package net.BukkitPE.block;

import net.BukkitPE.item.ItemTool;
import net.BukkitPE.utils.BlockColor;

/**
 * Created on 2015/11/25 by xtypr.
 * Package net.BukkitPE.block in project BukkitPE .
 */
public class BlockStairsNetherBrick extends BlockStairs {
    public BlockStairsNetherBrick() {
        this(0);
    }

    public BlockStairsNetherBrick(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return NETHER_BRICKS_STAIRS;
    }

    @Override
    public double getHardness() {
        return 2;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public String getName() {
        return "Nether Bricks Stairs";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.NETHERRACK_BLOCK_COLOR;
    }

}
