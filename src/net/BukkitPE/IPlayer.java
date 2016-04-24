package net.BukkitPE;

import net.BukkitPE.metadata.Metadatable;
import net.BukkitPE.permission.ServerOperator;


public interface IPlayer extends ServerOperator, Metadatable {


    boolean isOnline();
	
    String getName();
	
    boolean isBanned();
	
    void setBanned(boolean value);
	
    boolean isWhitelisted();
	
    void setWhitelisted(boolean value);
	
    Player getPlayer();
	
    Server getServer();
	
    Long getFirstPlayed();
	
    Long getLastPlayed();
	
    boolean hasPlayedBefore();

}
