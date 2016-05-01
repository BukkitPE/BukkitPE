<?php
namespace BukkitPE\event\entity;

use BukkitPE\entity\Entity;
use BukkitPE\Event;
use BukkitPE\event\Cancellable;
use BukkitPE\math\Vector3;

class EntityMotionEvent extends EntityEvent implements Cancellable{
	public static $handlerList = null;

	private $mot;

	public function __construct(Entity $entity, Vector3 $mot){
		$this->entity = $entity;
		$this->mot = $mot;
	}

	/**
	 * @return Vector3
	 */
	public function getVector(){
		return $this->mot;
	}


}