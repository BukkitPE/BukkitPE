package net.BukkitPE.item.food;

import net.BukkitPE.Player;
import net.BukkitPE.item.ItemBowl;

/**
 * Created by Snake1999 on 2016/1/14.
 * Package net.BukkitPE.item.food in project BukkitPE.
 */
public class FoodInBowl extends Food {

    public FoodInBowl(int restoreFood, float restoreSaturation) {
        this.setRestoreFood(restoreFood);
        this.setRestoreSaturation(restoreSaturation);
    }

    @Override
    protected boolean onEatenBy(Player player) {
        super.onEatenBy(player);
        player.getInventory().addItem(new ItemBowl());
        return true;
    }

}
