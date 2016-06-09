package net.BukkitPE.event.entity;

import net.BukkitPE.entity.Entity;
import net.BukkitPE.entity.EntityCreature;
import net.BukkitPE.entity.EntityHuman;
import net.BukkitPE.entity.item.EntityItem;
import net.BukkitPE.entity.item.EntityVehicle;
import net.BukkitPE.entity.projectile.EntityProjectile;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.level.Position;

/**

 * BukkitPE Project
 */
public class EntitySpawnEvent extends EntityEvent {
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private int entityType;

    public EntitySpawnEvent(Entity entity) {
        this.entity = entity;
        this.entityType = entity.getNetworkId();
    }

    public Position getPosition() {
        return this.entity.getPosition();
    }

    public int getType() {
        return this.entityType;
    }

    public boolean isCreature() {
        return this.entity instanceof EntityCreature;
    }

    public boolean isHuman() {
        return this.entity instanceof EntityHuman;
    }

    public boolean isProjectile() {
        return this.entity instanceof EntityProjectile;
    }

    public boolean isVehicle() {
        return this.entity instanceof EntityVehicle;
    }

    public boolean isItem() {
        return this.entity instanceof EntityItem;
    }

}
