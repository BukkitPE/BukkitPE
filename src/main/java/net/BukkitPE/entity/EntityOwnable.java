package net.BukkitPE.entity;

import net.BukkitPE.Player;

/**
 * Author: BeYkeRYkt
 * BukkitPE Project
 */
public interface EntityOwnable {
    String getOwnerName();

    void setOwnerName(String playerName);

    Player getOwner();
}
