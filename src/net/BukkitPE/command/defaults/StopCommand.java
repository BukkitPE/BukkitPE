package net.BukkitPE.command.defaults;

import net.BukkitPE.command.Command;
import net.BukkitPE.command.CommandSender;
import net.BukkitPE.event.TranslationContainer;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class StopCommand extends VanillaCommand {

    public StopCommand(String name) {
        super(name, "%BukkitPE.command.stop.description", "%commands.stop.usage");
        this.setPermission("BukkitPE.command.stop");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }

        Command.broadcastCommandMessage(sender, new TranslationContainer("commands.stop.start"));

        sender.getServer().shutdown();

        return true;
    }
}
