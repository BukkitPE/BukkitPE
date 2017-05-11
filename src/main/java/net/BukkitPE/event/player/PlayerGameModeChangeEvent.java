package net.BukkitPE.event.player;

import net.BukkitPE.Player;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

public class PlayerGameModeChangeEvent extends PlayerEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    protected final int gamemode;

    public PlayerGameModeChangeEvent(Player player, int newGameMode) {
        this.player = player;
        this.gamemode = newGameMode;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }

    public int getNewGamemode() {
        return gamemode;
    }
}
