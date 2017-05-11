package net.BukkitPE.metadata;

import net.BukkitPE.plugin.Plugin;

import java.lang.ref.WeakReference;

/**
 * BukkitPE Project
 */
public abstract class MetadataValue {

    protected final WeakReference<Plugin> owningPlugin;

    protected MetadataValue(Plugin owningPlugin) {
        this.owningPlugin = new WeakReference<>(owningPlugin);
    }

    public Plugin getOwningPlugin() {
        return this.owningPlugin.get();
    }

    public abstract Object value();

    public abstract void invalidate();

}
