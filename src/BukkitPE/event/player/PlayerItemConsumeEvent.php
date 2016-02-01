<?php
namespace BukkitPE\event\player;

use BukkitPE\event\Cancellable;
use BukkitPE\item\Item;
use BukkitPE\Player;

/**
 * Called when a player eats something
 */
class PlayerItemConsumeEvent extends PlayerEvent implements Cancellable{
	public static $handlerList = null;

	/** @var Item */
	private $item;

	/**
	 * @param Player $player
	 * @param Item   $item
	 */
	public function __construct(Player $player, Item $item){
		$this->player = $player;
		$this->item = $item;
	}

	/**
	 * @return Item
	 */
	public function getItem(){
		return clone $this->item;
	}

}