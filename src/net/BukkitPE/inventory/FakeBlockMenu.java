package net.BukkitPE.inventory;

import net.BukkitPE.level.Position;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class FakeBlockMenu extends Position implements InventoryHolder {

    private Inventory inventory;

    public FakeBlockMenu(Inventory inventory, Position pos) {
        super(pos.x, pos.y, pos.z, pos.level);
        this.inventory = inventory;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
