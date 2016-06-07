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
public class OpCommand extends VanillaCommand {

    public OpCommand(String name) {
        super(name, "%BukkitPE.command.op.description", "%commands.op.usage");
        this.setPermission("BukkitPE.command.op.give");
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

        String name = args[0];
        IPlayer player = sender.getServer().getOfflinePlayer(name);

        Command.broadcastCommandMessage(sender, new TranslationContainer("commands.op.success", player.getName()));
        if (player instanceof Player) {
            ((Player) player).sendMessage(TextFormat.GRAY + "You are now op!");
        }

        player.setOp(true);

        return true;
    }
}
