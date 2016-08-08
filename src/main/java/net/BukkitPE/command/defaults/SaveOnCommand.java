package net.BukkitPE.command.defaults;

import net.BukkitPE.command.Command;
import net.BukkitPE.command.CommandSender;
import net.BukkitPE.lang.TranslationContainer;

/**
 * Created on 2015/11/13 by xtypr.
 * Package net.BukkitPE.command.defaults in project BukkitPE .
 */
public class SaveOnCommand extends VanillaCommand {

    public SaveOnCommand(String name) {
        super(name, "%BukkitPE.command.saveon.description", "%commands.save-on.usage");
        this.setPermission("BukkitPE.command.save.enable");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }
        sender.getServer().setAutoSave(true);
        Command.broadcastCommandMessage(sender, new TranslationContainer("commands.save.enabled"));
        return true;
    }
}
