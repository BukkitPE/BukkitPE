package net.BukkitPE.event.redstone;

import net.BukkitPE.block.Block;
import net.BukkitPE.event.block.BlockUpdateEvent;

/**
 * author: Angelic47
 * BukkitPE Project
 */
public class RedstoneUpdateEvent extends BlockUpdateEvent {

    public RedstoneUpdateEvent(Block source) {
        super(source);
    }

}

