package net.BukkitPE.command.defaults;

import net.BukkitPE.command.Command;
import net.BukkitPE.command.CommandSender;
import net.BukkitPE.event.TranslationContainer;

import java.util.regex.Pattern;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class PardonIpCommand extends VanillaCommand {

    public PardonIpCommand(String name) {
        super(name, "%BukkitPE.command.unban.ip.description", "%commands.unbanip.usage");
        this.setPermission("BukkitPE.command.unban.ip");
        this.setAliases(new String[]{"unbanip", "unban-ip", "pardonip"});
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

        String value = args[0];

        if (Pattern.matches("^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$", value)) {
            sender.getServer().getIPBans().remove(value);

            Command.broadcastCommandMessage(sender, new TranslationContainer("commands.unbanip.success", value));
        } else {

            sender.sendMessage(new TranslationContainer("commands.unbanip.invalid"));
        }

        return true;
    }
}
