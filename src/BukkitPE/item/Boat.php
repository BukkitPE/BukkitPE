<?php
namespace BukkitPE\item;
use BukkitPE\level\Level;
use BukkitPE\block\Block;
use BukkitPE\Player;
use BukkitPE\nbt\tag\Compound;
use BukkitPE\nbt\tag\Enum;
use BukkitPE\nbt\tag\Double;
use BukkitPE\nbt\tag\Float;
use BukkitPE\entity\Boat as BoatEntity;

class Boat extends Item{
	public function __construct($meta = 0, $count = 1){
		parent::__construct(self::BOAT, $meta, $count, "Oak Boat");
		if($this->meta === 1){
			$this->name = "Spruce Boat";
		}elseif($this->meta === 2){
			$this->name = "Birch Boat";
		}elseif($this->meta === 3){
			$this->name = "Jungle Boat";
		}elseif($this->meta === 4){
			$this->name = "Acacia Boat";
		}elseif($this->meta === 5){
			$this->name = "Dark Oak Boat";
		}
	}
	
	public function getMaxStackSize(){
		return 1;
	}
	
	public function canBeActivated(){
		return true;
	}

	public function onActivate(Level $level, Player $player, Block $block, Block $target, $face, $fx, $fy, $fz){
		$realPos = $block->getSide($face);

		$boat = new BoatEntity($player->getLevel()->getChunk($realPos->getX() >> 4, $realPos->getZ() >> 4), new Compound("", [
			"Pos" => new Enum("Pos", [
				new Double("", $realPos->getX()),
				new Double("", $realPos->getY()),
				new Double("", $realPos->getZ())
			]),
			"Motion" => new Enum("Motion", [
				new Double("", 0),
				new Double("", 0),
				new Double("", 0)
			]),
			"Rotation" => new Enum("Rotation", [
				new Float("", 0),
				new Float("", 0)
			]),
		]));
		$boat->spawnToAll();

		if($player->isSurvival()) {
			$item = $player->getInventory()->getItemInHand();
			$count = $item->getCount();
			if(--$count <= 0){
				$player->getInventory()->setItemInHand(Item::get(Item::AIR));
				return;
			}

			$item->setCount($count);
			$player->getInventory()->setItemInHand($item);
		}
		
		return true;
	}
}
