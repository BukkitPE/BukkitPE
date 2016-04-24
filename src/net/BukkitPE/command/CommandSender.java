package net.BukkitPE.command;

import net.BukkitPE.Server;
import net.BukkitPE.event.TextContainer;
import net.BukkitPE.permission.Permissible;

public interface CommandSender extends Permissible{
	/**
     * Sends a message to the command sender.
     */
    void sendMessage(String message);

    /**
     * Sends a message to the command sender.
     */
    void sendMessage(TextContainer message);

    /**
     * Returns the server of the command sender.
     */
    Server getServer();

    /**
     * Returns the name of the command sender.
     */
    String getName();

	
	boolean isPlayer();
}
