<?php
namespace BukkitPE\event\player;

use BukkitPE\event\Cancellable;
use BukkitPE\item\Item;
use BukkitPE\Player;

/**
 * Called when a player tries to drop an item from its hotbar
 */
class PlayerDropItemEvent extends PlayerEvent implements Cancellable{
	public static $handlerList = null;

	/** @var Item */
	private $drop;

	/**
	 * @param Player $player
	 * @param Item   $drop
	 */
	public function __construct(Player $player, Item $drop){
		$this->player = $player;
		$this->drop = $drop;
	}

	/**
	 * @return Item
	 */
	public function getItem(){
		return $this->drop;
	}

}