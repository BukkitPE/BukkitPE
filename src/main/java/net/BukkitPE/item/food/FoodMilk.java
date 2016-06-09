package net.BukkitPE.item.food;

import net.BukkitPE.Player;
import net.BukkitPE.item.ItemBucket;

/**
 * Created by Snake1999 on 2016/1/21.
 * Package net.BukkitPE.item.food in project BukkitPE.
 */
public class FoodMilk extends Food {
    @Override
    protected boolean onEatenBy(Player player) {
        super.onEatenBy(player);
        player.getInventory().addItem(new ItemBucket());
        player.removeAllEffects();
        return true;
    }
}
