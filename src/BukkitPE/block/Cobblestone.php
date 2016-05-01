<?php
namespace BukkitPE\block;

use BukkitPE\item\Item;
use BukkitPE\item\Tool;

class Cobblestone extends Solid{

	protected $id = self::COBBLESTONE;
	public $exp_smelt = 0.1;

	public function __construct(){

	}

	public function getToolType(){
		return Tool::TYPE_PICKAXE;
	}

	public function getName(){
		return "Cobblestone";
	}

	public function getHardness(){
		return 2;
	}

	public function getDrops(Item $item){
		if($item->isPickaxe() >= Tool::TIER_WOODEN){
			return [
				[Item::COBBLESTONE, 0, 1],
			];
		}else{
			return [];
		}
	}
}