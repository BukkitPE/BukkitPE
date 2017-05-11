package net.BukkitPE.event.level;

import net.BukkitPE.event.HandlerList;
import net.BukkitPE.level.Level;
import net.BukkitPE.level.Position;

/**
 * BukkitPE Project
 */
public class SpawnChangeEvent extends LevelEvent {

    private static final HandlerList handlers = new HandlerList();
    private final Position previousSpawn;

    public SpawnChangeEvent(Level level, Position previousSpawn) {
        super(level);
        this.previousSpawn = previousSpawn;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public Position getPreviousSpawn() {
        return previousSpawn;
    }
}
