package net.BukkitPE.event.potion;

import net.BukkitPE.event.Event;
import net.BukkitPE.potion.Potion;

/**
 * Created by Snake1999 on 2016/1/12.
 * Package net.BukkitPE.event.potion in project BukkitPE
 */
public abstract class PotionEvent extends Event {

    private Potion potion;

    public PotionEvent(Potion potion) {
        this.potion = potion;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }

}
