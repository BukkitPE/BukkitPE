package net.BukkitPE.command.defaults;

import net.BukkitPE.Player;
import net.BukkitPE.command.CommandSender;
import net.BukkitPE.event.TranslationContainer;

/**
 * Created on 2015/11/11 by xtypr.
 * Package net.BukkitPE.command.defaults in project BukkitPE .
 */
public class ListCommand extends VanillaCommand {

    public ListCommand(String name) {
        super(name, "%BukkitPE.command.list.description", "%commands.players.usage");
        this.setPermission("BukkitPE.command.list");
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!this.testPermission(sender)) {
            return true;
        }
        String online = "";
        int onlineCount = 0;
        for (Player player : sender.getServer().getOnlinePlayers().values()) {
            if (player.isOnline() && (!(sender instanceof Player) || ((Player) sender).canSee(player))) {
                online += player.getDisplayName() + ", ";
                ++onlineCount;
            }
        }

        if (online.length() > 0) {
            online = online.substring(0, online.length() - 2);
        }

        sender.sendMessage(new TranslationContainer("commands.players.list",
                new String[]{String.valueOf(onlineCount), String.valueOf(sender.getServer().getMaxPlayers())}));
        sender.sendMessage(online);
        return true;
    }
}
