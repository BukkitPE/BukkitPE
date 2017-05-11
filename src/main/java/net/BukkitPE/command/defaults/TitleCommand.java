package net.BukkitPE.command.defaults;

import net.BukkitPE.network.protocol.SetTitlePacket;
import net.BukkitPE.command.CommandSender;

class TitleCommand extends VanillaCommand {

    public TitleCommand($name){
        super(name, "Title command", "/title <title> <subtitle> [text]");
        this.setPermission("BukkitPE.command.title");
    }

    public boolean execute(CommandSender sender, String currentAlias, String[] args){
        if(sender instanceof Player){
            if(!this.testPermission(sender)){
                return true;
            }
            if(count($args) <= 0 || count($args) > 3 ){
                sender.sendMessage("Usage: /title <title> <subtile> [text]");
                return false;
            }

            //TODO

        }
    }
}
