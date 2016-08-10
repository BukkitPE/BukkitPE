package net.BukkitPE.block;

import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemTool;
import net.BukkitPE.level.Level;
import net.BukkitPE.math.AxisAlignedBB;
import net.BukkitPE.math.Vector3;
import net.BukkitPE.utils.BlockColor;

/**
 * Created on 2015/12/2 by xtypr.
 * Package net.BukkitPE.block in project BukkitPE .
 */
public class BlockFarmland extends BlockTransparent {

    public BlockFarmland() {
        this(0);
    }

    public BlockFarmland(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Farmland";
    }

    @Override
    public int getId() {
        return FARMLAND;
    }

    @Override
    public double getResistance() {
        return 3;
    }

    @Override
    public double getHardness() {
        return 0.6;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_SHOVEL;
    }

    @Override
    protected AxisAlignedBB recalculateBoundingBox() {
        return new AxisAlignedBB(
                this.x,
                this.y,
                this.z,
                this.x + 1,
                this.y + 0.9375,
                this.z + 1
        );
    }

    @Override
    public int onUpdate(int type) {
        if (type == Level.BLOCK_UPDATE_RANDOM) {

            Vector3 v = new Vector3();
            
   if (this.level.getBlock(v.setComponents(x, this.y + 1, z)) instanceof BlockCrops) {
                return 0;
            }
            
            boolean found = false;
 
            for (int x = (int) this.x - 1; x <= this.x + 1; x++) {
                for (int z = (int) this.z - 1; z <= this.z + 1; z++) {
                    if (z == this.z && x == this.x) {
                        continue;
                    }

                    Block block = this.level.getBlock(v.setComponents(x, this.y, z));

                    if (block instanceof BlockWater) {
                        found = true;
                        break;
                    }
                }
            }

            Block block = this.level.getBlock(v.setComponents(x, y - 1, z));
            if (found || block instanceof BlockWater) {
                return Level.BLOCK_UPDATE_RANDOM;
            }

            this.level.setBlock(this, new BlockDirt(), true, true);

            return Level.BLOCK_UPDATE_RANDOM;
        }

        return 0;
    }

    @Override
    public int[][] getDrops(Item item) {
        return new int[][]{
                {Item.DIRT, 0, 1}
        };
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.DIRT_BLOCK_COLOR;
    }
}
