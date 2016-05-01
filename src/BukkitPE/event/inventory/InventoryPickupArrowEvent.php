<?php
namespace BukkitPE\event\inventory;

use BukkitPE\entity\Arrow;
use BukkitPE\event\Cancellable;
use BukkitPE\inventory\Inventory;

class InventoryPickupArrowEvent extends InventoryEvent implements Cancellable{
	public static $handlerList = null;

	/** @var Arrow */
	private $arrow;

	/**
	 * @param Inventory $inventory
	 * @param Arrow     $arrow
	 */
	public function __construct(Inventory $inventory, Arrow $arrow){
		$this->arrow = $arrow;
		parent::__construct($inventory);
	}

	/**
	 * @return Arrow
	 */
	public function getArrow(){
		return $this->arrow;
	}

}