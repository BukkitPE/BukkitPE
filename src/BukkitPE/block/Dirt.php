<?php
namespace BukkitPE\block;

use BukkitPE\item\Item;
use BukkitPE\item\Tool;
use BukkitPE\Player;

class Dirt extends Solid{

	protected $id = self::DIRT;

	public function __construct(){

	}

	public function canBeActivated(){
		return true;
	}

	public function getHardness(){
		return 0.5;
	}

	public function getToolType(){
		return Tool::TYPE_SHOVEL;
	}

	public function getName(){
		return "Dirt";
	}

	public function onActivate(Item $item, Player $player = null){
		if($item->isHoe()){
			$item->useOn($this);
			$this->getLevel()->setBlock($this, Block::get(Item::FARMLAND, 0), true);

			return true;
		}

		return false;
	}
}