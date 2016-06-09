package net.BukkitPE.block;

/**
 * Created on 2015/11/22 by xtypr.
 * Package net.BukkitPE.block in project BukkitPE .
 */
public class BlockPodzol extends BlockDirt {

    public BlockPodzol() {
        this(0);
    }

    public BlockPodzol(int meta) {
        super(0);
    }

    @Override
    public int getId() {
        return PODZOL;
    }

    @Override
    public String getName() {
        return "Podzol";
    }

}
