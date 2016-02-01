<?php
/**
 * Entity related Events, like spawn, inventory, attack...
 */
namespace BukkitPE\event\entity;

use BukkitPE\event\Event;

abstract class EntityEvent extends Event{
	/** @var \BukkitPE\entity\Entity */
	protected $entity;

	public function getEntity(){
		return $this->entity;
	}
}