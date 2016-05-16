<?php
namespace BukkitPE\item;

use BukkitPE\block\Block;
use BukkitPE\entity\Entity;
use BukkitPE\level\format\FullChunk;
use BukkitPE\level\Level;
use BukkitPE\nbt\tag\Compound;
use BukkitPE\nbt\tag\Double;
use BukkitPE\nbt\tag\Enum;
use BukkitPE\nbt\tag\Float;
use BukkitPE\nbt\tag\String;
use BukkitPE\Player;
use BukkitPE\utils\TextFormat;

class SpawnEgg extends Item{
	public function __construct($meta = 0, $count = 1){
		parent::__construct(self::SPAWN_EGG, $meta, $count, "Spawn Egg");
	}

	public function canBeActivated(){
		return true;
	}

	public function onActivate(Level $level, Player $player, Block $block, Block $target, $face, $fx, $fy, $fz){
		$entity = null;
		$chunk = $level->getChunk($block->getX() >> 4, $block->getZ() >> 4);

		if(!($chunk instanceof FullChunk)){
			return false;
		}

		$nbt = new Compound("", [
			"Pos" => new Enum("Pos", [
				new Double("", $block->getX() + 0.5),
				new Double("", $block->getY()),
				new Double("", $block->getZ() + 0.5)
			]),
			"Motion" => new Enum("Motion", [
				new Double("", 0),
				new Double("", 0),
				new Double("", 0)
			]),
			"Rotation" => new Enum("Rotation", [
				new Float("", lcg_value() * 360),
				new Float("", 0)
			]),
		]);

		if($this->hasCustomName()){
			$nbt->CustomName = new String("CustomName", $this->getCustomName());
		}

		$entity = Entity::createEntity($this->meta, $chunk, $nbt);
		if($entity instanceof Entity){
			$entity->setDataFlag(Entity::DATA_FLAGS, Entity::DATA_NO_AI, true);
			$entity->getLevel()->getServer()->broadcastPopup(TextFormat::RED . "Mob AI isn't implemented into BukkitPE yet!"); //Andre make it send a tip instead of broadcasting it.
			if($player->isSurvival()){
				--$this->count;
			}
			$entity->spawnToAll();
			return true;
		}
		return false;
	}
}
