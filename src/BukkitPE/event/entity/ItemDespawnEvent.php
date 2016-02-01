<?php
namespace BukkitPE\event\entity;

use BukkitPE\entity\Item;
use BukkitPE\event\Cancellable;

class ItemDespawnEvent extends EntityEvent implements Cancellable{
	public static $handlerList = null;

	/**
	 * @param Item $item
	 */
	public function __construct(Item $item){
		$this->entity = $item;

	}

	/**
	 * @return Item
	 */
	public function getEntity(){
		return $this->entity;
	}

}