<?php
namespace BukkitPE\event\entity;

use BukkitPE\entity\Entity;
use BukkitPE\Event;
use BukkitPE\event\Cancellable;
use BukkitPE\level\Position;
use BukkitPE\block\Block;

class EntityEnterPortalEvent extends EntityEvent implements Cancellable{
	public static $handlerList = null;

	public function __construct(Entity $entity, Block $portal){
		$this->entity = $entity;
		$this->portal = $portal;
	}
}