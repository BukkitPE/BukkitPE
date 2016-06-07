package net.BukkitPE.command.defaults;

import net.BukkitPE.Player;
import net.BukkitPE.command.CommandSender;
import net.BukkitPE.event.TranslationContainer;

/**

 * BukkitPE Project
 */
public class SeedCommand extends VanillaCommand {

    public SeedCommand(String name) {
        super(name, "%BukkitPE.command.seed.description", "%commands.seed.usage");
        this.setPermission("BukkitPE.command.seed");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }

        long seed;
        if (sender instanceof Player) {
            seed = ((Player) sender).getLevel().getSeed();
        } else {
            seed = sender.getServer().getDefaultLevel().getSeed();
        }

        sender.sendMessage(new TranslationContainer("commands.seed.success", String.valueOf(seed)));

        return true;
    }
}
