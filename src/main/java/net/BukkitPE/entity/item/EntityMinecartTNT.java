package net.BukkitPE.entity.item;

import net.BukkitPE.level.format.FullChunk;
import net.BukkitPE.nbt.tag.CompoundTag;

/**
 * Created by Snake1999 on 2016/1/30.
 * Package net.BukkitPE.entity.item in project BukkitPE.
 */
public class EntityMinecartTNT extends EntityMinecartEmpty {

    // TODO: 2016/1/30 NETWORK_ID

    public EntityMinecartTNT(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    // TODO: 2016/1/30 on update, if activator rail downsiade, make a explosion


}
