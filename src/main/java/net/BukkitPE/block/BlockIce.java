package net.BukkitPE.block;

import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemTool;
import net.BukkitPE.level.Level;
import net.BukkitPE.utils.BlockColor;

/**
 * BukkitPE Project
 */
public class BlockIce extends BlockTransparent {

    public BlockIce() {
        this(0);
    }

    public BlockIce(int meta) {
        super(0);
    }

    @Override
    public int getId() {
        return ICE;
    }

    @Override
    public String getName() {
        return "Ice";
    }

    @Override
    public double getResistance() {
        return 2.5;
    }

    @Override
    public double getHardness() {
        return 0.5;
    }

    @Override
    public double getFrictionFactor() {
        return 0.98;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public boolean onBreak(Item item) {
        this.getLevel().setBlock(this, new BlockWater(), true);
        return true;
    }

    @Override
    public int onUpdate(int type) {
        if (type == Level.BLOCK_UPDATE_RANDOM) {
            if (this.getLevel().getBlockLightAt((int) this.x, (int) this.y, (int) this.z) >= 12) {
                this.getLevel().setBlock(this, new BlockWater(), true);
                return Level.BLOCK_UPDATE_NORMAL;
            }
        }
        return 0;
    }

    @Override
    public int[][] getDrops(Item item) {
        return new int[0][0];
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.ICE_BLOCK_COLOR;
    }
}
