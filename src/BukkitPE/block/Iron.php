<?php
namespace BukkitPE\block;

use BukkitPE\item\Item;
use BukkitPE\item\Tool;

class Iron extends Solid{

	protected $id = self::IRON_BLOCK;

	public function __construct(){

	}

	public function getName(){
		return "Iron Block";
	}

	public function getToolType(){
		return Tool::TYPE_PICKAXE;
	}

	public function getHardness(){
		return 5;
	}

	public function getDrops(Item $item){
		if($item->isPickaxe() >= Tool::TIER_STONE){
			return [
				[Item::IRON_BLOCK, 0, 1],
			];
		}else{
			return [];
		}
	}
}