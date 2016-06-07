package net.BukkitPE.block;

/**
 * Created by Snake1999 on 2016/1/11.
 * Package net.BukkitPE.block in project BukkitPE
 */
public abstract class BlockPressurePlate extends BlockTransparent {

    protected BlockPressurePlate() {
        this(0);
    }

    protected BlockPressurePlate(int meta) {
        super(meta);
    }

    @Override
    public boolean canPassThrough() {
        return true;
    }

    //todo redstone here?
    //todo bounding box
}
