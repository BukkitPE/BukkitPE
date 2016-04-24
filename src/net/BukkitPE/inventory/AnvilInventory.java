package net.BukkitPE.inventory;

import net.BukkitPE.Player;
import net.BukkitPE.level.Position;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class AnvilInventory extends ContainerInventory {

    public AnvilInventory(Position position) {
        super(null, InventoryType.get(InventoryType.ANVIL));
        this.holder = new FakeBlockMenu(this, position);
    }

    @Override
    public FakeBlockMenu getHolder() {
        return (FakeBlockMenu) this.holder;
    }

    @Override
    public void onClose(Player who) {
        super.onClose(who);

        for (int i = 0; i < 2; ++i) {
            this.getHolder().getLevel().dropItem(this.getHolder().add(0.5, 0.5, 0.5), this.getItem(i));
            this.clear(i);
        }
    }
}
