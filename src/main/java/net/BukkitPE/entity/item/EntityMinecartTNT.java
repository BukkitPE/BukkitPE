package net.BukkitPE.entity.item;

import net.BukkitPE.level.format.FullChunk;
import net.BukkitPE.nbt.tag.CompoundTag;

/**
 * <p> MinecartTNT </p>
 * Package net.BukkitPE.entity.item in project BukkitPE.
 */
public class EntityMinecartTNT extends EntityMinecartEmpty {

    // TODO: 2016/1/30 NETWORK_ID

    public EntityMinecartTNT(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    public boolean onUpdate(int currentTick) {
         Block downSide = this.getLocation().floor().getLevelBlock();
         if (downSide.getId() == Block.ACTIVATOR_RAIL && downSide.isPowered()) {
             explode();
             kill();
        }
        return true;
    }
  		  
     public void explode() {
        EntityExplosionPrimeEvent event = new EntityExplosionPrimeEvent(this, 4);
      server.getPluginManager().callEvent(event);
       if (event.isCancelled()) {
           return;
       }
       Explosion explosion = new Explosion(this, event.getForce(), this);
       if (event.isBlockBreaking()) {
           explosion.explodeA();
       }
        explosion.explodeB();
     }


}
