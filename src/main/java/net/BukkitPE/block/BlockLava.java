package net.BukkitPE.block;

import net.BukkitPE.Player;
import net.BukkitPE.Server;
import net.BukkitPE.entity.Entity;
import net.BukkitPE.event.entity.EntityCombustByBlockEvent;
import net.BukkitPE.event.entity.EntityDamageByBlockEvent;
import net.BukkitPE.event.entity.EntityDamageEvent;
import net.BukkitPE.item.Item;
import net.BukkitPE.level.Level;
import net.BukkitPE.math.Vector3;
import net.BukkitPE.potion.Effect;
import net.BukkitPE.utils.BlockColor;

import java.util.Random;

/**

 * BukkitPE Project
 */
public class BlockLava extends BlockLiquid {

    public BlockLava() {
        this(0);
    }

    public BlockLava(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return LAVA;
    }

    @Override
    public int getLightLevel() {
        return 15;
    }

    @Override
    public String getName() {
        return "Lava";
    }

    @Override
    public void onEntityCollide(Entity entity) {
        entity.fallDistance *= 0.5;
        if (!entity.hasEffect(Effect.FIRE_RESISTANCE)) {
            EntityDamageByBlockEvent ev = new EntityDamageByBlockEvent(this, entity, EntityDamageEvent.CAUSE_LAVA, 4);
            entity.attack(ev);
        }

        EntityCombustByBlockEvent ev = new EntityCombustByBlockEvent(this, entity, 15);
        Server.getInstance().getPluginManager().callEvent(ev);
        if (!ev.isCancelled()) {
            entity.setOnFire(ev.getDuration());
        }

        entity.resetFallDistance();
    }

    @Override
    public boolean place(Item item, Block block, Block target, int face, double fx, double fy, double fz) {
        return this.place(item, block, target, face, fx, fy, fz, null);
    }

    @Override
    public boolean place(Item item, Block block, Block target, int face, double fx, double fy, double fz, Player player) {
        boolean ret = this.getLevel().setBlock(this, this, true, false);
        this.getLevel().scheduleUpdate(this, this.tickRate());

        return ret;
    }

    @Override
    public int onUpdate(int type) {
        int result = super.onUpdate(type);

        if (type == Level.BLOCK_UPDATE_RANDOM) {

            Random random = this.getLevel().rand;

            int i = random.nextInt(3);

            if (i > 0) {
                for (int k = 0; k < i; ++k) {
                    Vector3 v = this.add(random.nextInt(3) - 1, 1, random.nextInt(3) - 1);
                    Block block = this.getLevel().getBlock(v);

                    if (block.getId() == AIR) {
                        if (this.isSurroundingBlockFlammable(block)) {
                            BlockFire fire = new BlockFire();
                            this.getLevel().setBlock(v, fire, true);
                            this.getLevel().scheduleUpdate(v, fire.tickRate());
                            return Level.BLOCK_UPDATE_RANDOM;
                        }
                    } else if (block.isSolid()) {
                        return Level.BLOCK_UPDATE_RANDOM;
                    }
                }
            } else {
                for (int k = 0; k < 3; ++k) {
                    Vector3 v = this.add(random.nextInt(3) - 1, 0, random.nextInt(3) - 1);
                    Block block = this.getLevel().getBlock(v);

                    if (block.getSide(SIDE_UP).getId() == AIR && block.getBurnChance() > 0) {
                        BlockFire fire = new BlockFire();
                        this.getLevel().setBlock(v, fire, true);
                        this.getLevel().scheduleUpdate(v, fire.tickRate());
                    }
                }
            }

        }

        return result;
    }

    protected boolean isSurroundingBlockFlammable(Block block) {
        for (int side = 0; side <= 5; ++side) {
            if (block.getSide(side).getBurnChance() > 0) {
                return true;
            }
        }

        return false;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.LAVA_BLOCK_COLOR;
    }

    @Override
    public BlockLiquid getBlock(int meta) {
        return new BlockLava(meta);
    }
}
