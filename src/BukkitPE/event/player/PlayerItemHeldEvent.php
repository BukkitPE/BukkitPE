<?php
namespace BukkitPE\event\player;

use BukkitPE\Event;
use BukkitPE\event\Cancellable;
use BukkitPE\item\Item;
use BukkitPE\Player;

class PlayerItemHeldEvent extends PlayerEvent implements Cancellable{
	public static $handlerList = null;

	private $item;
	private $slot;
	private $inventorySlot;

	public function __construct(Player $player, Item $item, $inventorySlot, $slot){
		$this->player = $player;
		$this->item = $item;
		$this->inventorySlot = (int) $inventorySlot;
		$this->slot = (int) $slot;
	}

	public function getSlot(){
		return $this->slot;
	}

	public function getInventorySlot(){
		return $this->inventorySlot;
	}

	public function getItem(){
		return $this->item;
	}

}