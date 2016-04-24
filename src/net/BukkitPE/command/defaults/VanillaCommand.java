package net.BukkitPE.command.defaults;

import net.BukkitPE.command.Command;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public abstract class VanillaCommand extends Command {

    public VanillaCommand(String name) {
        super(name);
    }

    public VanillaCommand(String name, String description) {
        super(name, description);
    }

    public VanillaCommand(String name, String description, String usageMessage) {
        super(name, description, usageMessage);
    }

    public VanillaCommand(String name, String description, String usageMessage, String[] aliases) {
        super(name, description, usageMessage, aliases);
    }
}
