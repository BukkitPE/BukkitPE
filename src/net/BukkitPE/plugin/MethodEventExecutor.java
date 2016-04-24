package net.BukkitPE.plugin;

import net.BukkitPE.Server;
import net.BukkitPE.event.Event;
import net.BukkitPE.event.Listener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class MethodEventExecutor implements EventExecutor {

    private Method method;

    public MethodEventExecutor(Method method) {
        this.method = method;
    }

    @Override
    public void execute(Listener listener, Event event) {
        try {
            method.invoke(listener, event);
        } catch (IllegalAccessException | InvocationTargetException e) {
            Server.getInstance().getLogger().logException(e);
        }
    }
}
