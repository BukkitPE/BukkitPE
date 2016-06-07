package net.BukkitPE.block;

import net.BukkitPE.utils.BlockColor;

/**

 * BukkitPE Project
 */
public abstract class BlockTransparent extends Block {

    protected BlockTransparent(int meta) {
        super(meta);
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.TRANSPARENT_BLOCK_COLOR;
    }

}
