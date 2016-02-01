<?php
namespace BukkitPE\block;

use BukkitPE\item\Tool;
use BukkitPE\entity\Living;
use BukkitPE\item\Item;

class StonePressurePlate extends WoodenPressurePlate{

	protected $id = self::STONE_PRESSURE_PLATE;

	public function __construct($meta = 0){
		$this->meta = $meta;
	}
	
	public function getToolType(){
		return Tool::TYPE_PICKAXE;
	}

	public function getName(){
		return "Stone Pressure Plate";
	}

	public function getHardness(){
		return 0.5;
	}
	
	public function isEntityCollided(){
		foreach ($this->getLevel()->getChunk($this->x >> 4, $this->z >> 4)->getEntities() as $entity){
			if($entity instanceof Living && $this->getLevel()->getBlock($entity->getPosition()) === $this)
				return true;
		}
		return false;
	}

	public function getDrops(Item $item){
		if($item->isPickaxe()){
			return [$this->id, 0, 1];
		}
		return [];
	}
}