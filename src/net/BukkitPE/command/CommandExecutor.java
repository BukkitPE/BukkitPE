package net.BukkitPE.command;

public interface CommandExecutor {
	boolean onCommand(CommandSender sender, Command command, String labels, String[] args);
}
