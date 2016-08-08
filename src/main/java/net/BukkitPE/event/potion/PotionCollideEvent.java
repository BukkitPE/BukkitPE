package net.BukkitPE.event.potion;

import net.BukkitPE.entity.item.EntityPotion;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.potion.Potion;

/**
 * Created by Snake1999 on 2016/1/12.
 * Package net.BukkitPE.event.potion in project BukkitPE
 */
public class PotionCollideEvent extends PotionEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private final EntityPotion thrownPotion;

    public PotionCollideEvent(Potion potion, EntityPotion thrownPotion) {
        super(potion);
        this.thrownPotion = thrownPotion;
    }

    public EntityPotion getThrownPotion() {
        return thrownPotion;
    }
}
