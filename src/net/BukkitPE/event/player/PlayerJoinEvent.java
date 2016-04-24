/*
 *
 * ____        _    _    _ _   _____  ______ 
 * |  _ \      | |  | |  (_) | |  __ \|  ____|
 * | |_) |_   _| | _| | ___| |_| |__) | |__   
 * |  _ <| | | | |/ / |/ / | __|  ___/|  __|  
 * | |_) | |_| |   <|   <| | |_| |    | |____ 
 * |____/ \__,_|_|\_\_|\_\_|\__|_|    |______|
 *                                           
 *                                          
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * @author BukkitPE Team
 * @link http://www.bukkitpe.net/
 *
 *
*/
package net.BukkitPE.event.player;

import net.BukkitPE.event.TextContainer;
import net.BukkitPE.Player;

/**
 * Called when a player joins the server, after sending all the spawn packets
 */
class PlayerJoinEvent extends PlayerEvent{
	public static $handlerList = null;

	/** @var string|TextContainer */
	protected joinMessage;

	public void __construct(Player player, joinMessage){
		this.player = player;
		this.joinMessage = joinMessage;
	}

	/**
	 * @param string|TextContainer joinMessage
	 */
	public void setJoinMessage(joinMessage){
		this.joinMessage = joinMessage;
	}

	/**
	 * @return string|TextContainer
	 */
	public void getJoinMessage(){
		return this.joinMessage;
	}

}
