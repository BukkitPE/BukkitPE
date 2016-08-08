package net.BukkitPE.event.entity;

import net.BukkitPE.entity.Entity;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.math.Vector3;

/**

 * BukkitPE Project
 */
public class EntityMotionEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private final Vector3 motion;

    public EntityMotionEvent(Entity entity, Vector3 motion) {
        this.entity = entity;
        this.motion = motion;
    }

    @Deprecated
    public Vector3 getVector() {
        return this.motion;
    }

    public Vector3 getMotion() {
        return this.motion;
    }
}
