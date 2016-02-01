<?php
namespace BukkitPE\event\entity;

use BukkitPE\entity\Entity;
use BukkitPE\entity\Living;
use BukkitPE\entity\Projectile;
use BukkitPE\event\Cancellable;
use BukkitPE\item\Item;

class EntityLaunchFishingRodEvent extends EntityEvent implements Cancellable{
	public static $handlerList = null;

	/** @var Item */
	private $rod;
	/** @var Projectile */
	private $projectile;
	/** @var float */
	private $force;

	/**
	 * @param Living     $shooter
	 * @param Item       $rod
	 * @param Projectile $projectile
	 * @param float      $force
	 */
	public function __construct(Living $shooter, Item $rod, Projectile $projectile, $force){
		$this->entity = $shooter;
		$this->rod = $rod;
		$this->projectile = $projectile;
		$this->force = $force;
	}

	/**
	 * @return Living
	 */
	public function getEntity(){
		return $this->entity;
	}

	/**
	 * @return Item
	 */
	public function getRod(){
		return $this->rod;
	}

	/**
	 * @return Entity
	 */
	public function getProjectile(){
		return $this->projectile;
	}

	/**
	 * @param Entity $projectile
	 */
	public function setProjectile(Entity $projectile){
		if($projectile !== $this->projectile){
			if(count($this->projectile->getViewers()) === 0){
				$this->projectile->kill();
				$this->projectile->close();
			}
			$this->projectile = $projectile;
		}
	}

	/**
	 * @return float
	 */
	public function getForce(){
		return $this->force;
	}

	/**
	 * @param float $force
	 */
	public function setForce($force){
		$this->force = $force;
	}


}