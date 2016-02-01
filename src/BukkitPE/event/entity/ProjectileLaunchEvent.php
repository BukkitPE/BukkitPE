<?php
namespace BukkitPE\event\entity;

use BukkitPE\entity\Projectile;
use BukkitPE\event\Cancellable;

class ProjectileLaunchEvent extends EntityEvent implements Cancellable{
	public static $handlerList = null;

	/**
	 * @param Projectile $entity
	 */
	public function __construct(Projectile $entity){
		$this->entity = $entity;

	}

	/**
	 * @return Projectile
	 */
	public function getEntity(){
		return $this->entity;
	}

}