package net.BukkitPE.command.defaults;

import net.BukkitPE.command.Command;
import net.BukkitPE.command.CommandSender;
import net.BukkitPE.event.TranslationContainer;
import net.BukkitPE.utils.TextFormat;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class ReloadCommand extends VanillaCommand {

    public ReloadCommand(String name) {
        super(name, "%BukkitPE.command.reload.description", "%commands.reload.usage");
        this.setPermission("BukkitPE.command.reload");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }

        Command.broadcastCommandMessage(sender, new TranslationContainer(TextFormat.YELLOW + "%BukkitPE.command.reload.reloading" + TextFormat.WHITE));

        sender.getServer().reload();

        Command.broadcastCommandMessage(sender, new TranslationContainer(TextFormat.YELLOW + "%BukkitPE.command.reload.reloaded" + TextFormat.WHITE));

        return true;
    }
}
