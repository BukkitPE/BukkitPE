package net.BukkitPE.event.block;

import net.BukkitPE.Player;
import net.BukkitPE.block.Block;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

/**
 * Created by Snake1999 on 2016/1/22.
 * Package net.BukkitPE.event.block in project BukkitPE.
 */
public class DoorToggleEvent extends BlockUpdateEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private Player player;

    public DoorToggleEvent(Block block, Player player) {
        super(block);
        this.player = player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
