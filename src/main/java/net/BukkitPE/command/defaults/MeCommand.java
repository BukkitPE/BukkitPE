package net.BukkitPE.command.defaults;

import net.BukkitPE.Player;
import net.BukkitPE.command.CommandSender;
import net.BukkitPE.event.TranslationContainer;
import net.BukkitPE.utils.TextFormat;

/**
 * Created on 2015/11/12 by xtypr.
 * Package net.BukkitPE.command.defaults in project BukkitPE .
 */
public class MeCommand extends VanillaCommand {

    public MeCommand(String name) {
        super(name, "%BukkitPE.command.me.description", "%commands.me.usage");
        this.setPermission("BukkitPE.command.me");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));

            return false;
        }

        String name;
        if (sender instanceof Player) {
            name = ((Player) sender).getDisplayName();
        } else {
            name = sender.getName();
        }

        String msg = "";
        for (String arg : args) {
            msg += arg + " ";
        }

        if (msg.length() > 0) {
            msg = msg.substring(0, msg.length() - 1);
        }

        sender.getServer().broadcastMessage(new TranslationContainer("chat.type.emote", new String[]{name, TextFormat.WHITE + msg}));

        return true;
    }
}
