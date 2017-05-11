package net.BukkitPE.event;

/**
 * Created by BukkitPE Team.
 */
public interface Cancellable {

    boolean isCancelled();

    void setCancelled(boolean forceCancel);

    void setCancelled();
}
