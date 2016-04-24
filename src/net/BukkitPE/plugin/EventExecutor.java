package net.BukkitPE.plugin;

import net.BukkitPE.event.Event;
import net.BukkitPE.event.Listener;

/**
 * author: iNevet
 * BukkitPE Project
 */
public interface EventExecutor {

    void execute(Listener listener, Event event);
}
