package net.BukkitPE.command.defaults;

import net.BukkitPE.Server;
import net.BukkitPE.command.CommandSender;
import net.BukkitPE.lang.TranslationContainer;

/**
 * Created on 2015/11/12 by xtypr.
 * Package net.BukkitPE.command.defaults in project BukkitPE .
 */
public class DefaultGamemodeCommand extends VanillaCommand {

    public DefaultGamemodeCommand(String name) {
        super(name, "%BukkitPE.command.defaultgamemode.description", "%commands.defaultgamemode.usage");
        this.setPermission("BukkitPE.command.defaultgamemode");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(new TranslationContainer("commands.generic.usage", new String[]{this.usageMessage}));
            return false;
        }
        int gameMode = Server.getGamemodeFromString(args[0]);
        if (gameMode != -1) {
            sender.getServer().setPropertyInt("gamemode", gameMode);
            sender.sendMessage(new TranslationContainer("commands.defaultgamemode.success", new String[]{Server.getGamemodeString(gameMode)}));
        } else {
            sender.sendMessage("Unknown game mode"); //
        }
        return true;
    }
}
