package net.BukkitPE.event.player;

import net.BukkitPE.Player;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.lang.TextContainer;

public class PlayerKickEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    protected final String reason;
    protected TextContainer quitMessage;

    public PlayerKickEvent(Player player, String reason, TextContainer quitMessage) {
        this.player = player;
        this.quitMessage = quitMessage;
        this.reason = reason;
    }

    public PlayerKickEvent(Player player, String reason, String quitMessage) {
        this.player = player;
        this.quitMessage = new TextContainer(quitMessage);
        this.reason = reason;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public String getReason() {
        return reason;
    }

    public TextContainer getQuitMessage() {
        return quitMessage;
    }

    public void setQuitMessage(String joinMessage) {
        this.setQuitMessage(new TextContainer(joinMessage));
    }

    public void setQuitMessage(TextContainer quitMessage) {
        this.quitMessage = quitMessage;
    }
}
