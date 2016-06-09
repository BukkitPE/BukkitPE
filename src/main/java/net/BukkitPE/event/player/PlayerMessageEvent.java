package net.BukkitPE.event.player;

/**
 * Created on 2015/12/23 by xtypr.
 * Package net.BukkitPE.event.player in project BukkitPE .
 */
public abstract class PlayerMessageEvent extends PlayerEvent {

    protected String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
