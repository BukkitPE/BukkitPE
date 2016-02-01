<?php
namespace BukkitPE\block;

use BukkitPE\item\Item;
use BukkitPE\item\Tool;

class Emerald extends Solid{

	protected $id = self::EMERALD_BLOCK;

	public function __construct(){

	}

	public function getHardness(){
		return 5;
	}

	public function getToolType(){
		return Tool::TYPE_PICKAXE;
	}

	public function getName(){
		return "Emerald Block";
	}

	public function getDrops(Item $item){
		if($item->isPickaxe() >= Tool::TIER_IRON){
			return [
				[Item::EMERALD_BLOCK, 0, 1],
			];
		}else{
			return [];
		}
	}
}