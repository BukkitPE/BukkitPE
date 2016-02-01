<?php
namespace BukkitPE\event\inventory;

use BukkitPE\entity\Item;
use BukkitPE\event\Cancellable;
use BukkitPE\inventory\Inventory;

class InventoryPickupItemEvent extends InventoryEvent implements Cancellable{
	public static $handlerList = null;

	/** @var Item */
	private $item;

	/**
	 * @param Inventory $inventory
	 * @param Item      $item
	 */
	public function __construct(Inventory $inventory, Item $item){
		$this->item = $item;
		parent::__construct($inventory);
	}

	/**
	 * @return Item
	 */
	public function getItem(){
		return $this->item;
	}

}