package net.BukkitPE.command.defaults;

import net.BukkitPE.command.Command;
import net.BukkitPE.command.CommandSender;
import net.BukkitPE.event.TranslationContainer;

/**
 * Created on 2015/11/13 by xtypr.
 * Package net.BukkitPE.command.defaults in project BukkitPE .
 */
public class SaveOffCommand extends VanillaCommand {

    public SaveOffCommand(String name) {
        super(name, "%BukkitPE.command.saveoff.description", "%commands.save-off.usage");
        this.setPermission("BukkitPE.command.save.disable");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }
        sender.getServer().setAutoSave(false);
        Command.broadcastCommandMessage(sender, new TranslationContainer("commands.save.disabled"));
        return true;
    }
}
