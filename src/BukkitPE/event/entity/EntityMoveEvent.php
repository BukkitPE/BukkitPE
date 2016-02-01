<?php
namespace BukkitPE\event\entity;

use BukkitPE\entity\Entity;
use BukkitPE\Event;
use BukkitPE\event\Cancellable;
use BukkitPE\math\Vector3;

/**
 * @deprecated
 */
class EntityMoveEvent extends EntityEvent implements Cancellable{
	public static $handlerList = null;

	/** @var \BukkitPE\math\Vector3 */
	private $pos;

	public function __construct(Entity $entity, Vector3 $pos){
		$this->entity = $entity;
		$this->pos = $pos;
	}

	public function getVector(){
		return $this->pos;
	}


}