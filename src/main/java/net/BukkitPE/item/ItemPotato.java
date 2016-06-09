package net.BukkitPE.item;

import net.BukkitPE.block.BlockPotato;

/**

 * BukkitPE Project
 */
public class ItemPotato extends ItemEdible {

    public ItemPotato() {
        this(0, 1);
    }

    public ItemPotato(Integer meta) {
        this(meta, 1);
    }

    public ItemPotato(Integer meta, int count) {
        super(POTATO, meta, count, "Potato");
        this.block = new BlockPotato();
    }

    protected ItemPotato(int id, Integer meta, int count, String name) {
        super(id, meta, count, name);
    }
}
