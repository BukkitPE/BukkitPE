<?php
namespace BukkitPE\event\entity;

use BukkitPE\entity\Entity;
use BukkitPE\Event;
use BukkitPE\event\Cancellable;
use BukkitPE\level\Position;

class EntityPortalTeleportEvent extends EntityTeleportEvent implements Cancellable{
	public static $handlerList = null;

	/** @var Position */
	private $from;
	/** @var Position */
	private $to;

	public function __construct(Entity $entity, Position $from, Position $to){
		$this->entity = $entity;
		$this->from = $from;
		$this->to = $to;
	}

	/**
	 * @return Position
	 */
	public function getFrom(){
		return $this->from;
	}

	/**
	 * @param Position $from
	 */
	public function setFrom(Position $from){
		$this->from = $from;
	}

	/**
	 * @return Position
	 */
	public function getTo(){
		return $this->to;
	}

	/**
	 * @param Position $to
	 */
	public function setTo(Position $to){
		$this->to = $to;
	}


}