package net.BukkitPE.block;

/**
 * Created by Snake1999 on 2016/1/11.
 * Package net.BukkitPE.block in project BukkitPE
 */
public abstract class BlockWeightedPressurePlate extends BlockTransparent {

    public BlockWeightedPressurePlate(int meta) {
        super(meta);
    }

    public BlockWeightedPressurePlate() {
        this(0);
    }

    @Override
    public boolean canPassThrough() {
        return true;
    }
}
