<?php
/**
 * Inventory related events
 */
namespace BukkitPE\event\inventory;

use BukkitPE\event\Event;
use BukkitPE\inventory\Inventory;

abstract class InventoryEvent extends Event{

	/** @var Inventory */
	protected $inventory;

	public function __construct(Inventory $inventory){
		$this->inventory = $inventory;
	}

	/**
	 * @return Inventory
	 */
	public function getInventory(){
		return $this->inventory;
	}

	/**
	 * @return \BukkitPE\entity\Human[]
	 */
	public function getViewers(){
		return $this->inventory->getViewers();
	}
}