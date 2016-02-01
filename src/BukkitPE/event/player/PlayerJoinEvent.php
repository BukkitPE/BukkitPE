<?php
namespace BukkitPE\event\player;

use BukkitPE\event\TextContainer;
use BukkitPE\Player;

/**
 * Called when a player joins the server, after sending all the spawn packets
 */
class PlayerJoinEvent extends PlayerEvent{
	public static $handlerList = null;

	/** @var string|TextContainer */
	protected $joinMessage;

	public function __construct(Player $player, $joinMessage){
		$this->player = $player;
		$this->joinMessage = $joinMessage;
	}

	/**
	 * @param string|TextContainer $joinMessage
	 */
	public function setJoinMessage($joinMessage){
		$this->joinMessage = $joinMessage;
	}

	/**
	 * @return string|TextContainer
	 */
	public function getJoinMessage(){
		return $this->joinMessage;
	}

}