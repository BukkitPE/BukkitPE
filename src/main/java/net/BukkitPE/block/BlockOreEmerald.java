package net.BukkitPE.block;

import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemTool;
import net.BukkitPE.math.BukkitPERandom;

/**
 * Created on 2015/12/1 by xtypr.
 * Package net.BukkitPE.block in project BukkitPE .
 */
public class BlockOreEmerald extends BlockSolid {

    public BlockOreEmerald() {
        this(0);
    }

    public BlockOreEmerald(int meta) {
        super(0);
    }

    @Override
    public String getName() {
        return "Emerald Ore";
    }

    @Override
    public int getId() {
        return EMERALD_ORE;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public double getHardness() {
        return 3;
    }

    @Override
    public double getResistance() {
        return 15;
    }

    @Override
    public int[][] getDrops(Item item) {
        if (item.isPickaxe() && item.getTier() >= ItemTool.TIER_IRON) {
            return new int[][]{
                    {Item.EMERALD, 0, 1}
            };
        } else {
            return new int[0][0];
        }
    }

    @Override
    public int getDropExp() {
        return new BukkitPERandom().nextRange(3, 7);
    }
}
