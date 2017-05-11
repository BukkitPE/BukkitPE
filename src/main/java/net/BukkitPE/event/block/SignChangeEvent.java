package net.BukkitPE.event.block;

import net.BukkitPE.Player;
import net.BukkitPE.block.Block;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

/**
 * BukkitPE Project
 */
public class SignChangeEvent extends BlockEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private String[] lines = new String[4];

    public SignChangeEvent(Block block, Player player, String[] lines) {
        super(block);
        this.player = player;
        this.lines = lines;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public Player getPlayer() {
        return player;
    }

    public String[] getLines() {
        return lines;
    }

    public String getLine(int index) {
        return this.lines[index];
    }

    public void setLine(int index, String line) {
        this.lines[index] = line;
    }
}
