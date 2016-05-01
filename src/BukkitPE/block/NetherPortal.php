<?php

namespace BukkitPE\block;

use BukkitPE\item\Item;
use BukkitPE\Server;
use BukkitPE\entity\Entity;
use BukkitPE\event\entity\EntityEnterPortalEvent;

class NetherPortal extends Flowable{
	protected $id = self::NETHER_PORTAL;

	public function __construct($meta = 0){
		$this->meta = $meta;
	}

	public function getLightLevel(){
		return 15;
	}

	public function getName(){
		return "Nether Portal";
	}

	public function getDrops(Item $item){
		return;
	}

	public function onEntityCollide(Entity $entity){
		Server::getInstance()->getPluginManager()->callEvent($ev = new EntityEnterPortalEvent($entity, $this));
		if(!$ev->isCancelled()){
			return true;
		}
		return false;
	}

	public function canPassThrough(){
		return true;
	}
	
	/*
	 * public function canBeReplaced(){
	 * return true;
	 * }
	 */
	// TODO: only source blocks of liquids
}
