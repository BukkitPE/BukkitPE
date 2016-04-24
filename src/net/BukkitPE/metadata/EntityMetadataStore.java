package net.BukkitPE.metadata;

import net.BukkitPE.entity.Entity;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class EntityMetadataStore extends MetadataStore {

    @Override
    protected String disambiguate(Metadatable entity, String metadataKey) {
        if (!(entity instanceof Entity)) {
            throw new IllegalArgumentException("Argument must be an Entity instance");
        }
        return ((Entity) entity).getId() + ":" + metadataKey;
    }
}
