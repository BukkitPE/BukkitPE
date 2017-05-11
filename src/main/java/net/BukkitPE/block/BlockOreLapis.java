package net.BukkitPE.block;

import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemTool;
import net.BukkitPE.math.BukkitPERandom;

import java.util.Random;

/**
 * BukkitPE Project
 */
public class BlockOreLapis extends BlockSolid {


    public BlockOreLapis() {
        this(0);
    }

    public BlockOreLapis(int meta) {
        super(0);
    }

    @Override
    public int getId() {
        return LAPIS_ORE;
    }

    @Override
    public double getHardness() {
        return 3;
    }

    @Override
    public double getResistance() {
        return 5;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public String getName() {
        return "Lapis Lazuli Ore";
    }

    @Override
    public int[][] getDrops(Item item) {
        if (item.isPickaxe() && item.getTier() >= ItemTool.TIER_STONE) {
            return new int[][]{
                    {Item.DYE, 4, new Random().nextInt(4) + 4}
            };
        } else {
            return new int[0][0];
        }
    }

    @Override
    public int getDropExp() {
        return new BukkitPERandom().nextRange(2, 5);
    }
}
