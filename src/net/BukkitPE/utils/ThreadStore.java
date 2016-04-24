package net.BukkitPE.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class ThreadStore {
    public static Map<String, Object> store = new ConcurrentHashMap<>();
}
