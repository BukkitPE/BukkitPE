package net.BukkitPE.event.entity;

import net.BukkitPE.block.Block;
import net.BukkitPE.entity.Entity;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

/**
 * Created on 15-10-26.
 */
public class EntityBlockChangeEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private final Block from;
    private final Block to;

    public EntityBlockChangeEvent(Entity entity, Block from, Block to) {
        this.entity = entity;
        this.from = from;
        this.to = to;
    }

    public Block getFrom() {
        return from;
    }

    public Block getTo() {
        return to;
    }

}
