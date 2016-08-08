package net.BukkitPE.event.server;

import net.BukkitPE.command.CommandSender;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;

/**

 * BukkitPE Project
 */
public class ServerCommandEvent extends ServerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    protected String command;

    protected final CommandSender sender;

    public ServerCommandEvent(CommandSender sender, String command) {
        this.sender = sender;
        this.command = command;
    }

    public CommandSender getSender() {
        return sender;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public static HandlerList getHandlers() {
        return handlers;
    }
}
