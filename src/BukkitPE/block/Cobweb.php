<?php
namespace BukkitPE\block;

use BukkitPE\entity\Entity;
use BukkitPE\item\Item;
use BukkitPE\item\Tool;

class Cobweb extends Flowable{

	protected $id = self::COBWEB;

	public function __construct(){

	}

	public function hasEntityCollision(){
		return true;
	}

	public function getName(){
		return "Cobweb";
	}

	public function getHardness(){
		return 4;
	}

	public function getToolType(){
		return Tool::TYPE_SWORD;
	}

	public function onEntityCollide(Entity $entity){
		$entity->resetFallDistance();
	}

	public function getDrops(Item $item){
		//TODO: correct drops
		return [];
	}
}