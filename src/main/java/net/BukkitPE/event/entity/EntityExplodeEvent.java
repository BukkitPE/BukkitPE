package net.BukkitPE.event.entity;

import net.BukkitPE.block.Block;
import net.BukkitPE.entity.Entity;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.level.Position;

import java.util.List;

/**
 * author: Angelic47
 * BukkitPE Project
 */
public class EntityExplodeEvent extends EntityEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    protected final Position position;
    protected List<Block> blocks;
    protected double yield;

    public EntityExplodeEvent(Entity entity, Position position, List<Block> blocks, double yield) {
        this.entity = entity;
        this.position = position;
        this.blocks = blocks;
        this.yield = yield;
    }

    public Position getPosition() {
        return this.position;
    }

    public List<Block> getBlockList() {
        return this.blocks;
    }

    public void setBlockList(List<Block> blocks) {
        this.blocks = blocks;
    }

    public double getYield() {
        return this.yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

}
