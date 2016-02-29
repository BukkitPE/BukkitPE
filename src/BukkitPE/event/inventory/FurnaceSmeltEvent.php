<?php
namespace BukkitPE\event\inventory;

use BukkitPE\event\block\BlockEvent;
use BukkitPE\event\Cancellable;
use BukkitPE\item\Item;
use BukkitPE\tile\Furnace;

class FurnaceSmeltEvent extends BlockEvent implements Cancellable{
	public static $handlerList = null;

	private $furnace;
	private $source;
	private $result;

	public function __construct(Furnace $furnace, Item $source, Item $result){
		parent::__construct($furnace->getBlock());
		$this->source = clone $source;
		$this->source->setCount(0);
		$this->result = $result;
		$this->furnace = $furnace;
	}

	/**
	 * @return Furnace
	 */
	public function getFurnace(){
		return $this->furnace;
	}

	/**
	 * @return Item
	 */
	public function getSource(){
		return $this->source;
	}

	/**
	 * @return Item
	 */
	public function getResult(){
		return $this->result;
	}

	/**
	 * @param Item $result
	 */
	public function setResult(Item $result){
		$this->result = $result;
	}
}
