<?php
namespace BukkitPE\event\entity;

use BukkitPE\entity\Living;
use BukkitPE\item\Item;

class EntityDeathEvent extends EntityEvent{
	public static $handlerList = null;

	/** @var Item[] */
	private $drops = [];


	/**
	 * @param Living $entity
	 * @param Item[] $drops
	 */
	public function __construct(Living $entity, array $drops = []){
		$this->entity = $entity;
		$this->drops = $drops;

	}

	/**
	 * @return Living
	 */
	public function getEntity(){
		return $this->entity;
	}

	/**
	 * @return \BukkitPE\item\Item[]
	 */
	public function getDrops(){
		return $this->drops;
	}

	/**
	 * @param Item[] $drops
	 */
	public function setDrops(array $drops){
		$this->drops = $drops;
	}

}