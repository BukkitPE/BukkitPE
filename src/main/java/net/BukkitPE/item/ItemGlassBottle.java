package net.BukkitPE.item;


import net.BukkitPE.Player;
import net.BukkitPE.block.Block;
import net.BukkitPE.level.Level;

public class ItemGlassBottle extends Item {

    public ItemGlassBottle() {
        this(0, 1);
    }

    public ItemGlassBottle(int meta) {
        this(meta, 1);
    }

    public ItemGlassBottle(int meta, int count) {
        super(GLASS_BOTTLE, meta, count, "Glass Bottle");
    }

    @Override
    public boolean onActivate(Level level, Player player, Block block, Block target, int face, double fx, double fy, double fz) {
        boolean isWater = false;

        if (target.getId() == WATER || target.getId() == STILL_WATER) {
            isWater = true;
        }

        if (isWater) {
            if (this.getCount() > 1) {
                if (player.getInventory().canAddItem(Item.get(Item.POTION))) {
                    this.setCount(this.getCount() - 1);
                    player.getInventory().addItem(Item.get(Item.POTION));
                    return true;
                }
            } else {
                player.getInventory().setItemInHand(Item.get(Item.POTION));
            }
        }

        return false;
    }
}