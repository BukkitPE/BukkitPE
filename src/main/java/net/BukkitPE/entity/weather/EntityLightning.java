package net.BukkitPE.entity.weather;

import net.BukkitPE.Player;
import net.BukkitPE.Server;
import net.BukkitPE.block.Block;
import net.BukkitPE.block.BlockFire;
import net.BukkitPE.entity.Entity;
import net.BukkitPE.entity.EntityLiving;
import net.BukkitPE.entity.item.EntityItem;
import net.BukkitPE.entity.mob.EntityCreeper;
import net.BukkitPE.event.entity.EntityDamageByEntityEvent;
import net.BukkitPE.event.entity.EntityDamageEvent;
import net.BukkitPE.level.format.FullChunk;
import net.BukkitPE.math.Vector3;
import net.BukkitPE.nbt.tag.CompoundTag;
import net.BukkitPE.network.protocol.AddEntityPacket;

/**
 * Created by boybook on 2016/2/27.
 */
public class EntityLightning extends Entity implements EntityLightningStrike {

    public static final int NETWORK_ID = 93;

    protected boolean isEffect = true;

    public EntityLightning(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    @Override
    protected void initEntity() {
        super.initEntity();

        this.setHealth(4);
        this.setMaxHealth(4);
    }

    public boolean isEffect() {
        return this.isEffect;
    }

    public void setEffect(boolean e) {
        this.isEffect = e;
    }

    @Override
    public void spawnTo(Player player) {
        AddEntityPacket pk = new AddEntityPacket();
        pk.eid = this.getId();
        pk.type = EntityLightning.NETWORK_ID;
        pk.x = (float) this.x;
        pk.y = (float) this.y;
        pk.z = (float) this.z;
        pk.speedX = 0;
        pk.speedY = 0;
        pk.speedZ = 0;
        pk.yaw = (float) this.yaw;
        pk.pitch = (float) this.pitch;
        pk.metadata = this.dataProperties;
        player.dataPacket(pk);

        super.spawnTo(player);
    }

    @Override
    public void attack(EntityDamageEvent source) {
        source.setDamage(0);
        super.attack(source);
        if (source.isCancelled()) return;
    }

    @Override
    public boolean onUpdate(int currentTick) {
        if (this.closed) {
            return false;
        }

        if (this.justCreated) {
            if (this.isEffect()) {
                for (Entity e : this.level.getNearbyEntities(this.boundingBox.grow(6, 12, 6), this)) {
                    if (e instanceof EntityLiving) {
                        e.attack(new EntityDamageByEntityEvent(this, e, EntityDamageEvent.CAUSE_LIGHTNING, 5));
                        e.setOnFire(5);  //how long?
                        //Creeper
                        if (e instanceof EntityCreeper) {
                            if (!((EntityCreeper) e).isPowered()) {
                                ((EntityCreeper) e).setPowered(this);
                            }
                        }
                        //TODO Pig
                        //TODO Villager
                    } else if (e instanceof EntityItem) {
                        e.kill();
                    }
                }
                if (Server.getInstance().getDifficulty() >= 2) {
                    Block block = this.getLevelBlock();
                    if (block.getId() == 0 || block.getId() == Block.TALL_GRASS && block.getId() == Block.GRASS) {
                        BlockFire fire = new BlockFire();
                        fire.x = block.x;
                        fire.y = block.y;
                        fire.z = block.z;
                        fire.level = level;
                        this.getLevel().setBlock(fire, fire, true);
                        if (fire.isBlockTopFacingSurfaceSolid(fire.getSide(Vector3.SIDE_DOWN)) || fire.canNeighborBurn()) {
                            level.setBlock(fire, fire, true);
                            level.scheduleUpdate(fire, fire.tickRate() + level.rand.nextInt(10));
                        }
                    }
                }
            }

        }

        int tickDiff = currentTick - this.lastUpdate;

        if (tickDiff <= 0 && !this.justCreated) {
            return true;
        }

        this.lastUpdate = currentTick;

        boolean hasUpdate = true;
        this.entityBaseTick(tickDiff);

        if (this.isAlive()) {
            if (this.age >= 1) {
                this.close();
                hasUpdate = false;
            }
        }

        return hasUpdate;
    }


}
