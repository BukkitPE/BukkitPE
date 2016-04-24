package net.BukkitPE.entity.mob;

import net.BukkitPE.entity.EntityCreature;
import net.BukkitPE.level.format.FullChunk;
import net.BukkitPE.nbt.tag.CompoundTag;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public abstract class EntityMob extends EntityCreature {
    public EntityMob(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }
}
