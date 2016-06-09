package net.BukkitPE.command.defaults;

import net.BukkitPE.IPlayer;
import net.BukkitPE.Player;
import net.BukkitPE.command.Command;
import net.BukkitPE.command.CommandSender;
import net.BukkitPE.event.TranslationContainer;
import net.BukkitPE.utils.TextFormat;

/**
 * Created on 2015/11/12 by xtypr.
 * Package net.BukkitPE.command.defaults in project BukkitPE .
 */
public class DeopCommand extends VanillaCommand {
    public DeopCommand(String name) {
        super(name, "%BukkitPE.command.deop.description", "%commands.deop.usage");
        this.setPermission("BukkitPE.command.op.take");
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

        String playerName = args[0];
        IPlayer player = sender.getServer().getOfflinePlayer(playerName);
        player.setOp(false);

        if (player instanceof Player) {
            ((Player) player).sendMessage(TextFormat.GRAY + "You are no longer op!");
        }

        Command.broadcastCommandMessage(sender, new TranslationContainer("commands.deop.success", new String[]{player.getName()}));

        return true;
    }
}
