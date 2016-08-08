package net.BukkitPE.command.defaults;

import net.BukkitPE.Server;
import net.BukkitPE.command.Command;
import net.BukkitPE.command.CommandSender;
import net.BukkitPE.lang.TranslationContainer;
import net.BukkitPE.network.protocol.SetDifficultyPacket;

import java.util.ArrayList;

/**
 * Created on 2015/11/12 by xtypr.
 * Package net.BukkitPE.command.defaults in project BukkitPE .
 */
public class DifficultyCommand extends VanillaCommand {

    public DifficultyCommand(String name) {
        super(name, "%BukkitPE.command.difficulty.description", "%commands.difficulty.usage");
        this.setPermission("BukkitPE.command.difficulty");
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

        int difficulty = Server.getDifficultyFromString(args[0]);

        if (sender.getServer().isHardcore()) {
            difficulty = 3;
        }

        if (difficulty != -1) {
            sender.getServer().setPropertyInt("difficulty", difficulty);

            SetDifficultyPacket pk = new SetDifficultyPacket();
            pk.difficulty = sender.getServer().getDifficulty();
            Server.broadcastPacket(new ArrayList<>(sender.getServer().getOnlinePlayers().values()), pk);

            Command.broadcastCommandMessage(sender, new TranslationContainer("commands.difficulty.success", String.valueOf(difficulty)));
        } else {
            sender.sendMessage(new TranslationContainer("commands.generic.usage", this.usageMessage));

            return false;
        }

        return true;
    }
}
