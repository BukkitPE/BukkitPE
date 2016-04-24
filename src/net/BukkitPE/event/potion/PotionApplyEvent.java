package net.BukkitPE.event.potion;

import net.BukkitPE.entity.Entity;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.potion.Potion;

/**
 * Created by Snake1999 on 2016/1/12.
 * Package net.BukkitPE.event.potion in project BukkitPE
 */
public class PotionApplyEvent extends PotionEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private Entity entity;

    public PotionApplyEvent(Potion potion, Entity entity) {
        super(potion);
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

}
