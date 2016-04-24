package net.BukkitPE.utils;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class PriorityObject {
    public int priority;
    public Object data;

    public PriorityObject(Object data, int priority) {
        this.data = data;
        this.priority = priority;
    }
}
