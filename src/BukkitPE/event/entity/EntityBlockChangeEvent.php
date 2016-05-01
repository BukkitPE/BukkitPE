<?php
namespace BukkitPE\event\entity;

use BukkitPE\block\Block;
use BukkitPE\entity\Entity;
use BukkitPE\event\Cancellable;

/**
 * Called when an Entity, excluding players, changes a block directly
 */
class EntityBlockChangeEvent extends EntityEvent implements Cancellable{
	public static $handlerList = null;

	private $from;
	private $to;

	public function __construct(Entity $entity, Block $from, Block $to){
		$this->entity = $entity;
		$this->from = $from;
		$this->to = $to;
	}

	/**
	 * @return Block
	 */
	public function getBlock(){
		return $this->from;
	}

	/**
	 * @return Block
	 */
	public function getTo(){
		return $this->to;
	}

}