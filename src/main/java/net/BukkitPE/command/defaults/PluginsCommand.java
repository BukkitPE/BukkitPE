package net.BukkitPE.command.defaults;

import net.BukkitPE.command.CommandSender;
import net.BukkitPE.lang.TranslationContainer;
import net.BukkitPE.plugin.Plugin;
import net.BukkitPE.utils.TextFormat;

import java.util.Map;

/**
 * Created on 2015/11/12 by xtypr.
 * Package net.BukkitPE.command.defaults in project BukkitPE .
 */
public class PluginsCommand extends VanillaCommand {

    public PluginsCommand(String name) {
        super(name,
                "%BukkitPE.command.plugins.description",
                "%BukkitPE.command.plugins.usage",
                new String[]{"pl"}
        );
        this.setPermission("BukkitPE.command.plugins");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }

        this.sendPluginList(sender);
        return true;
    }

    private void sendPluginList(CommandSender sender) {
        String list = "";
        Map<String, Plugin> plugins = sender.getServer().getPluginManager().getPlugins();
        for (Plugin plugin : plugins.values()) {
            if (list.length() > 0) {
                list += TextFormat.WHITE + ", ";
            }
            list += plugin.isEnabled() ? TextFormat.GREEN : TextFormat.RED;
            list += plugin.getDescription().getFullName();
        }

        sender.sendMessage(new TranslationContainer("BukkitPE.command.plugins.success", new String[]{String.valueOf(plugins.size()), list}));
    }
}
