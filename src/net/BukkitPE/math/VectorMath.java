package net.BukkitPE.math;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */

public abstract class VectorMath {

    public static Vector2 getDirection2D(double azimuth) {
        return new Vector2(Math.cos(azimuth), Math.sin(azimuth));
    }

}
