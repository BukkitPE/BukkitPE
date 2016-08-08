package net.BukkitPE.event.inventory;

import net.BukkitPE.blockentity.BlockEntityFurnace;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.event.block.BlockEvent;
import net.BukkitPE.item.Item;

/**

 * BukkitPE Project
 */
public class FurnaceBurnEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private final BlockEntityFurnace furnace;
    private final Item fuel;
    private short burnTime;
    private boolean burning = true;

    public FurnaceBurnEvent(BlockEntityFurnace furnace, Item fuel, short burnTime) {
        super(furnace.getBlock());
        this.fuel = fuel;
        this.burnTime = burnTime;
        this.furnace = furnace;
    }

    public BlockEntityFurnace getFurnace() {
        return furnace;
    }

    public Item getFuel() {
        return fuel;
    }

    public short getBurnTime() {
        return burnTime;
    }

    public void setBurnTime(short burnTime) {
        this.burnTime = burnTime;
    }

    public boolean isBurning() {
        return burning;
    }

    public void setBurning(boolean burning) {
        this.burning = burning;
    }
}