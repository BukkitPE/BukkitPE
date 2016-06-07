package net.BukkitPE.entity;

import net.BukkitPE.Player;

/**
 * Author: BeYkeRYkt
 * BukkitPE Project
 */
public interface EntityOwnable {
    public String getOwnerName();

    public void setOwnerName(String playerName);

    public Player getOwner();
}
