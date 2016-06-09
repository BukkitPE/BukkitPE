package net.BukkitPE.block;

import net.BukkitPE.item.ItemTool;
import net.BukkitPE.math.AxisAlignedBB;
import net.BukkitPE.utils.BlockColor;

/**
 * Created on 2015/11/22 by xtypr.
 * Package net.BukkitPE.block in project BukkitPE .
 */
public class BlockGrassPath extends BlockGrass {

    public BlockGrassPath() {
        this(0);
    }

    public BlockGrassPath(int meta) {
        super(0);
    }

    @Override
    public int getId() {
        return GRASS_PATH;
    }

    @Override
    public String getName() {
        return "Grass Path";
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_SHOVEL;
    }

    @Override
    protected AxisAlignedBB recalculateBoundingBox() {
        return new AxisAlignedBB(
                this.x,
                this.y,
                this.z,
                this.x + 1,
                this.y + 0.9375,
                this.z + 1
        );
    }

    @Override
    public double getResistance() {
        return 3.25;
    }

    @Override
    public BlockColor getColor() {
        //todo edit this after minecraft pc 1.9 come out
        return BlockColor.GRASS_BLOCK_COLOR;
    }

}
