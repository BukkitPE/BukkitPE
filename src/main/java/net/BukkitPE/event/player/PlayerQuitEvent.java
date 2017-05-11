package net.BukkitPE.event.player;

import net.BukkitPE.Player;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.lang.TextContainer;

public class PlayerQuitEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();
    protected TextContainer quitMessage;
    protected boolean autoSave = true;
    public PlayerQuitEvent(Player player, TextContainer quitMessage) {
        this(player, quitMessage, true);
    }

    public PlayerQuitEvent(Player player, String quitMessage) {
        this(player, quitMessage, true);
    }

    public PlayerQuitEvent(Player player, String quitMessage, boolean autoSave) {
        this(player, new TextContainer(quitMessage), autoSave);
    }

    public PlayerQuitEvent(Player player, TextContainer quitMessage, boolean autoSave) {
        this.player = player;
        this.quitMessage = quitMessage;
        this.autoSave = autoSave;
    }

    public static HandlerList getHandlers() {
        return handlers;
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

    public boolean getAutoSave() {
        return this.autoSave;
    }

    public void setAutoSave(boolean autoSave) {
        this.autoSave = autoSave;
    }

    public void setAutoSave() {
        this.setAutoSave(true);
    }
}
