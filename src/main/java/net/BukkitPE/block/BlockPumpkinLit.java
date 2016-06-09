package net.BukkitPE.block;

/**
 * Created on 2015/12/8 by xtypr.
 * Package net.BukkitPE.block in project BukkitPE .
 */
public class BlockPumpkinLit extends BlockPumpkin {
    public BlockPumpkinLit() {
        this(0);
    }

    public BlockPumpkinLit(int meta) {
        super(0);
    }

    @Override
    public String getName() {
        return "Jack o'Lantern";
    }

    @Override
    public int getId() {
        return LIT_PUMPKIN;
    }

    @Override
    public int getLightLevel() {
        return 15;
    }

}
