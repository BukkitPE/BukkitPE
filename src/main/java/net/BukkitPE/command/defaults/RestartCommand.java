package net.BukkitPE.command.defaults;

import net.BukkitPE.command.Command;
import net.BukkitPE.command.CommandSender;
import net.BukkitPE.lang.TranslationContainer;

/**
 * BukkitPE Project
 * 08/31/2016
 */
public class RestartCommand extends VanillaCommand {

    public RestartCommand(String name) {
        super(name, "%BukkitPE.command.restart.description", "%commands.restart.usage");
        this.setPermission("BukkitPE.command.restart");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }

        Command.broadcastCommandMessage(sender, new TranslationContainer("commands.restart.start"));

        sender.getServer().restart();

        return true;
    }
}
