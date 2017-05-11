package net.BukkitPE.entity.data;

import net.BukkitPE.entity.Entity;
import net.BukkitPE.math.Vector3;

/**
 * BukkitPE Project
 */
public class PositionEntityData extends EntityData<Vector3> {
    public int x;
    public int y;
    public int z;

    public PositionEntityData(int id, int x, int y, int z) {
        super(id);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public PositionEntityData(int id, Vector3 pos) {
        this(id, (int) pos.x, (int) pos.y, (int) pos.z);
    }

    @Override
    public Vector3 getData() {
        return new Vector3(x, y, z);
    }

    @Override
    public void setData(Vector3 data) {
        if (data != null) {
            this.x = (int) data.x;
            this.y = (int) data.y;
            this.z = (int) data.z;
        }
    }

    @Override
    public int getType() {
        return Entity.DATA_TYPE_POS;
    }
}
