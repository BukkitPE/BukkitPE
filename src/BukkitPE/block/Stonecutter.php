<?php
namespace BukkitPE\block;

use BukkitPE\item\Item;
use BukkitPE\item\Tool;
use BukkitPE\Player;

//TODO: check orientation
class Stonecutter extends Solid{

	protected $id = self::STONECUTTER;

	public function __construct($meta = 0){
		$this->meta = $meta;
	}

	public function getName(){
		return "Stonecutter";
	}

	public function getToolType(){
		return Tool::TYPE_PICKAXE;
	}

	public function getDrops(Item $item){
		if($item->isPickaxe() >= Tool::TIER_WOODEN){
			return [
				[Item::STONECUTTER, 0, 1],
			];
		}else{
			return [];
		}
	}
}
