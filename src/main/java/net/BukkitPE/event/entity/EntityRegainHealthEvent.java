package net.BukkitPE.event.entity;

import net.BukkitPE.entity.Entity;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

/**

 * BukkitPE Project
 */
public class EntityRegainHealthEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    public static final int CAUSE_REGEN = 0;
    public static final int CAUSE_EATING = 1;
    public static final int CAUSE_MAGIC = 2;
    public static final int CAUSE_CUSTOM = 3;

    private float amount;
    private final int reason;

    public EntityRegainHealthEvent(Entity entity, float amount, int regainReason) {
        this.entity = entity;
        this.amount = amount;
        this.reason = regainReason;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getRegainReason() {
        return reason;
    }
}
