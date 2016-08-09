package net.BukkitPE.blockentity;

import net.BukkitPE.Player;
import net.BukkitPE.block.Block;
import net.BukkitPE.block.BlockAir;
import net.BukkitPE.inventory.BaseInventory;
import net.BukkitPE.inventory.ChestInventory;
import net.BukkitPE.inventory.DoubleChestInventory;
import net.BukkitPE.inventory.InventoryHolder;
import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemBlock;
import net.BukkitPE.level.format.FullChunk;
import net.BukkitPE.math.Vector3;
import net.BukkitPE.nbt.tag.CompoundTag;
import net.BukkitPE.nbt.tag.ListTag;

/**

 * BukkitPE Project
 */
public class BlockEntityChest extends BlockEntitySpawnable implements InventoryHolder, BlockEntityContainer, BlockEntityNameable {

    protected final ChestInventory inventory;

    protected DoubleChestInventory doubleInventory = null;

    public BlockEntityChest(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
        this.inventory = new ChestInventory(this);

        if (!this.namedTag.contains("Items") || !(this.namedTag.get("Items") instanceof ListTag)) {
            this.namedTag.putList(new ListTag<CompoundTag>("Items"));
        }

        for (int i = 0; i < this.getSize(); i++) {
            this.inventory.setItem(i, this.getItem(i));
        }
    }

    @Override
    public void close() {
        if (!this.closed) {
            for (Player player : this.getInventory().getViewers()) {
                player.removeWindow(this.getInventory());
            }

            for (Player player : this.getInventory().getViewers()) {
                player.removeWindow(this.getRealInventory());
            }
            super.close();
        }
    }

    @Override
    public void saveNBT() {
        this.namedTag.putList(new ListTag<CompoundTag>("Items"));
        for (int index = 0; index < this.getSize(); index++) {
            this.setItem(index, this.inventory.getItem(index));
        }
    }

    @Override
    public boolean isBlockEntityValid() {
        // TODO: 2016/2/4 TRAPPED_CHEST?
        return getBlock().getId() == Block.CHEST;
    }

    @Override
    public int getSize() {
        return 27;
    }

    protected int getSlotIndex(int index) {
        ListTag<CompoundTag> list = this.namedTag.getList("Items", CompoundTag.class);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getByte("Slot") == index) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public Item getItem(int index) {
        int i = this.getSlotIndex(index);
        if (i < 0) {
            return new ItemBlock(new BlockAir(), 0, 0);
        } else {
            CompoundTag data = (CompoundTag) this.namedTag.getList("Items").get(i);
            return Item.get(data.getShort("id"), data.getShort("Damage"), data.getByte("Count"));
        }
    }

 	@Override
	public void setItem(int index, Item item) {
		int i = this.getSlotIndex(index);

		CompoundTag d = new CompoundTag().putByte("Count", item.getCount()).putByte("Slot", index)
				.putShort("id", item.getId()).putShort("Damage", item.getDamage());
		if (item.hasEnchantments()) {
			d.putList(new ListTag<CompoundTag>("ench"));
			for (Enchantment enchantment : item.getEnchantments()) {
				d.getList("ench", CompoundTag.class).add(
						new CompoundTag().putShort("id", enchantment.getId()).putShort("lvl", enchantment.getLevel()));
			}
		}

		if (item.getId() == Item.AIR || item.getCount() <= 0) {
			if (i >= 0) {
				this.namedTag.getList("Items").remove(i);
			}
		} else if (i < 0) {
			(this.namedTag.getList("Items", CompoundTag.class)).add(d);
		} else {
			(this.namedTag.getList("Items", CompoundTag.class)).add(i, d);
		}
	}

    @Override
    public BaseInventory getInventory() {
        if (this.isPaired() && this.doubleInventory == null) {
            this.checkPairing();
        }

        return this.doubleInventory != null ? this.doubleInventory : this.inventory;
    }

    public ChestInventory getRealInventory() {
        return inventory;
    }

    protected void checkPairing() {
        BlockEntityChest pair = this.getPair();
        if (pair != null) {
            if (!pair.isPaired()) {
                pair.createPair(this);
                pair.checkPairing();
            }

            if (this.doubleInventory == null) {
                if ((pair.x + ((int) pair.z << 15)) > (this.x + ((int) this.z << 15))) { //Order them correctly
                    this.doubleInventory = new DoubleChestInventory(pair, this);
                } else {
                    this.doubleInventory = new DoubleChestInventory(this, pair);
                }
            }
        } else {
            this.doubleInventory = null;
            this.namedTag.remove("pairx");
            this.namedTag.remove("pairz");
        }
    }

    @Override
    public String getName() {
        return this.hasName() ? this.namedTag.getString("CustomName") : "Chest";
    }

    @Override
    public boolean hasName() {
        return this.namedTag.contains("CustomName");
    }

    @Override
    public void setName(String name) {
        if (name == null || name.equals("")) {
            this.namedTag.remove("CustomName");
            return;
        }

        this.namedTag.putString("CustomName", name);
    }

    public boolean isPaired() {
        return this.namedTag.contains("pairx") && this.namedTag.contains("pairz");
    }

    public BlockEntityChest getPair() {
        if (this.isPaired()) {
            BlockEntity blockEntity = this.getLevel().getBlockEntity(new Vector3(this.namedTag.getInt("pairx"), this.y, this.namedTag.getInt("pairz")));
            if (blockEntity instanceof BlockEntityChest) {
                return (BlockEntityChest) blockEntity;
            }
        }

        return null;
    }

    public boolean pairWith(BlockEntityChest chest) {
        if (this.isPaired() || chest.isPaired()) {
            return false;
        }

        this.createPair(chest);

        chest.spawnToAll();
        this.spawnToAll();
        this.checkPairing();

        return true;
    }

    public void createPair(BlockEntityChest chest) {
        this.namedTag.putInt("pairx", (int) chest.x);
        this.namedTag.putInt("pairz", (int) chest.z);
        chest.namedTag.putInt("pairx", (int) this.x);
        chest.namedTag.putInt("pairz", (int) this.z);
    }

    public boolean unpair() {
        if (!this.isPaired()) {
            return false;
        }

        BlockEntityChest chest = this.getPair();

        this.namedTag.remove("pairx");
        this.namedTag.remove("pairz");

        this.spawnToAll();

        if (chest != null) {
            chest.namedTag.remove("pairx");
            chest.namedTag.remove("pairz");
            chest.checkPairing();
            chest.spawnToAll();
        }
        this.checkPairing();

        return true;
    }

    @Override
    public CompoundTag getSpawnCompound() {
        CompoundTag c;
        if (this.isPaired()) {
            c = new CompoundTag()
                    .putString("id", BlockEntity.CHEST)
                    .putInt("x", (int) this.x)
                    .putInt("y", (int) this.y)
                    .putInt("z", (int) this.z)
                    .putInt("pairx", this.namedTag.getInt("pairx"))
                    .putInt("pairz", this.namedTag.getInt("pairz"));
        } else {
            c = new CompoundTag()
                    .putString("id", BlockEntity.CHEST)
                    .putInt("x", (int) this.x)
                    .putInt("y", (int) this.y)
                    .putInt("z", (int) this.z);
        }

        if (this.hasName()) {
            c.put("CustomName", this.namedTag.get("CustomName"));
        }

        return c;
    }

}
