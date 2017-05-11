package net.BukkitPE.plugin;

import net.BukkitPE.event.Event;
import net.BukkitPE.event.Listener;
import net.BukkitPE.utils.EventException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * BukkitPE Project
 */
public class MethodEventExecutor implements EventExecutor {

    private final Method method;

    public MethodEventExecutor(Method method) {
        this.method = method;
    }

    @Override
    public void execute(Listener listener, Event event) throws EventException {
        try {
            method.invoke(listener, event);
        } catch (InvocationTargetException ex) {
            throw new EventException(ex.getCause());
        } catch (Throwable t) {
            throw new EventException(t);
        }
    }

    public Method getMethod() {
        return method;
    }
}
