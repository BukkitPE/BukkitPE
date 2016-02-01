<?php
namespace BukkitPE\event\entity;

use BukkitPE\entity\Entity;
use BukkitPE\event\Cancellable;

class EntityCombustEvent extends EntityEvent implements Cancellable{
	public static $handlerList = null;

	protected $duration;

	/**
	 * @param Entity $combustee
	 * @param int    $duration
	 */
	public function __construct(Entity $combustee, $duration){
		$this->entity = $combustee;
		$this->duration = $duration;
	}

	public function getDuration(){
		return $this->duration;
	}

	public function setDuration($duration){
		$this->duration = (int) $duration;
	}

}