package net.BukkitPE.entity;

import net.BukkitPE.level.format.FullChunk;
import net.BukkitPE.nbt.tag.CompoundTag;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public abstract class EntityCreature extends EntityLiving {
    public EntityCreature(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }
}
