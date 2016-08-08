package net.BukkitPE.block;

/**
 * author: Angelic47
 * BukkitPE Project
 */
public class BlockFurnace extends BlockFurnaceBurning {

    public BlockFurnace() {
        this(0);
    }

    public BlockFurnace(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Furnace";
    }

    @Override
    public int getId() {
        return FURNACE;
    }
}
