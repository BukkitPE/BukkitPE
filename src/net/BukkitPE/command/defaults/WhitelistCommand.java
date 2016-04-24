package net.BukkitPE.command.defaults;

import net.BukkitPE.command.Command;
import net.BukkitPE.command.CommandSender;
import net.BukkitPE.event.TranslationContainer;
import net.BukkitPE.utils.TextFormat;

/**
 * Created on 2015/11/12 by xtypr.
 * Package net.BukkitPE.command.defaults in project BukkitPE .
 */
public class WhitelistCommand extends VanillaCommand {

    public WhitelistCommand(String name) {
        super(name, "%BukkitPE.command.whitelist.description", "%commands.whitelist.usage");
        this.setPermission(
                "BukkitPE.command.whitelist.reload;" +
                        "BukkitPE.command.whitelist.enable;" +
                        "BukkitPE.command.whitelist.disable;" +
                        "BukkitPE.command.whitelist.list;" +
                        "BukkitPE.command.whitelist.add;" +
                        "BukkitPE.command.whitelist.remove"
        );
    }


    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }

        if (args.length == 0 || args.length > 2) {
            sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));
            return true;
        }

        if (args.length == 1) {
            if (this.badPerm(sender, args[0].toLowerCase())) {
                return false;
            }
            switch (args[0].toLowerCase()) {
                case "reload":
                    sender.getServer().reloadWhitelist();
                    Command.broadcastCommandMessage(sender, new TranslationContainer("commands.whitelist.reloaded"));

                    return true;
                case "on":
                    sender.getServer().setPropertyBoolean("white-list", true);
                    Command.broadcastCommandMessage(sender, new TranslationContainer("commands.whitelist.enabled"));

                    return true;
                case "off":
                    sender.getServer().setPropertyBoolean("white-list", false);
                    Command.broadcastCommandMessage(sender, new TranslationContainer("commands.whitelist.disabled"));

                    return true;
                case "list":
                    String result = "";
                    int count = 0;
                    for (String player : sender.getServer().getWhitelist().getAll().keySet()) {
                        result += player + ", ";
                        ++count;
                    }
                    sender.sendMessage(new TranslationContainer("commands.whitelist.list", new String[]{String.valueOf(count), String.valueOf(count)}));
                    sender.sendMessage(result.substring(0, result.length() - 2));

                    return true;

                case "add":
                    sender.sendMessage(new TranslationContainer("commands.generic.usage", "%commands.whitelist.add.usage"));
                    return true;

                case "remove":
                    sender.sendMessage(new TranslationContainer("commands.generic.usage", "%commands.whitelist.remove.usage"));
                    return true;
            }
        } else if (args.length == 2) {
            if (this.badPerm(sender, args[0].toLowerCase())) {
                return false;
            }
            switch (args[0].toLowerCase()) {
                case "add":
                    sender.getServer().getOfflinePlayer(args[1]).setWhitelisted(true);
                    Command.broadcastCommandMessage(sender, new TranslationContainer("commands.whitelist.add.success", args[1]));

                    return true;
                case "remove":
                    sender.getServer().getOfflinePlayer(args[1]).setWhitelisted(false);
                    Command.broadcastCommandMessage(sender, new TranslationContainer("commands.whitelist.remove.success", args[1]));

                    return true;
            }
        }

        return true;
    }

    private boolean badPerm(CommandSender sender, String perm) {
        if (!sender.hasPermission("BukkitPE.command.whitelist" + perm)) {
            sender.sendMessage(new TranslationContainer(TextFormat.RED + "%commands.generic.permission"));

            return true;
        }

        return false;
    }
}
