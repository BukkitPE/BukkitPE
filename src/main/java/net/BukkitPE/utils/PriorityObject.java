package net.BukkitPE.utils;

/**

 * BukkitPE Project
 */
public class PriorityObject {
    public final int priority;
    public final Object data;

    public PriorityObject(Object data, int priority) {
        this.data = data;
        this.priority = priority;
    }
}
