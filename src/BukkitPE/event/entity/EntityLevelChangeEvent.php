<?php
namespace BukkitPE\event\entity;

use BukkitPE\entity\Entity;
use BukkitPE\Event;
use BukkitPE\event\Cancellable;
use BukkitPE\level\Level;

class EntityLevelChangeEvent extends EntityEvent implements Cancellable{
	public static $handlerList = null;

	private $originLevel;
	private $targetLevel;

	public function __construct(Entity $entity, Level $originLevel, Level $targetLevel){
		$this->entity = $entity;
		$this->originLevel = $originLevel;
		$this->targetLevel = $targetLevel;
	}

	public function getOrigin(){
		return $this->originLevel;
	}

	public function getTarget(){
		return $this->targetLevel;
	}
}