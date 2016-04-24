package net.BukkitPE.event.player;

import net.BukkitPE.Player;
import net.BukkitPE.block.Block;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.item.Item;
import net.BukkitPE.level.Position;
import net.BukkitPE.math.Vector3;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class PlayerInteractEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    public static final int LEFT_CLICK_BLOCK = 0;
    public static final int RIGHT_CLICK_BLOCK = 1;
    public static final int LEFT_CLICK_AIR = 2;
    public static final int RIGHT_CLICK_AIR = 3;
    public static final int PHYSICAL = 4;

    protected Block blockTouched;

    protected Vector3 touchVector;

    protected int blockFace;

    protected Item item;

    protected int action;

    public PlayerInteractEvent(Player player, Item item, Vector3 block, int face) {
        this(player, item, block, face, RIGHT_CLICK_BLOCK);
    }

    public PlayerInteractEvent(Player player, Item item, Vector3 block, int face, int action) {
        if (block instanceof Block) {
            this.blockTouched = (Block) block;
            this.touchVector = new Vector3(0, 0, 0);
        } else {
            this.touchVector = block;
            this.blockTouched = Block.get(Block.AIR, 0, new Position(0, 0, 0, player.level));
        }

        this.player = player;
        this.item = item;
        this.blockFace = face;
        this.action = action;
    }

    public int getAction() {
        return action;
    }

    public Item getItem() {
        return item;
    }

    public Block getBlock() {
        return blockTouched;
    }

    public Vector3 getTouchVector() {
        return touchVector;
    }

    public int getFace() {
        return blockFace;
    }
}
