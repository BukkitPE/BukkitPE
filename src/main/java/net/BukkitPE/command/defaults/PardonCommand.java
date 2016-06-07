package net.BukkitPE.command.defaults;

import net.BukkitPE.command.Command;
import net.BukkitPE.command.CommandSender;
import net.BukkitPE.event.TranslationContainer;

/**

 * BukkitPE Project
 */
public class PardonCommand extends VanillaCommand {

    public PardonCommand(String name) {
        super(name, "%BukkitPE.command.unban.player.description", "%commands.unban.usage");
        this.setPermission("BukkitPE.command.unban.player");
        this.setAliases(new String[]{"unban"});
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));

            return false;
        }

        sender.getServer().getNameBans().remove(args[0]);

        Command.broadcastCommandMessage(sender, new TranslationContainer("%commands.unban.success", args[0]));

        return true;
    }
}
