<?php
namespace BukkitPE\block;

use BukkitPE\entity\Entity;
use BukkitPE\item\Item;
use BukkitPE\nbt\tag\Byte;
use BukkitPE\nbt\tag\Compound;
use BukkitPE\nbt\tag\Double;
use BukkitPE\nbt\tag\Enum;
use BukkitPE\nbt\tag\Float;
use BukkitPE\Player;
use BukkitPE\level\Level;
use BukkitPE\utils\Random;
use BukkitPE\item\FlintSteel;

class TNT extends Solid implements Redstone, RedstoneConsumer{

	protected $id = self::TNT;

	public function __construct(){

	}

	public function getName(){
		return "TNT";
	}

	public function getHardness(){
		return 0;
	}

	public function canBeActivated(){
		return true;
	}

	public function onActivate(Item $item, Player $player = null){
		if($item->getId() === Item::FLINT_STEEL){
			$item->useOn($this);
			$this->getLevel()->setBlock($this, new Air(), true);

			$mot = (new Random())->nextSignedFloat() * M_PI * 2;
			$tnt = Entity::createEntity("PrimedTNT", $this->getLevel()->getChunk($this->x >> 4, $this->z >> 4), new Compound("", [
				"Pos" => new Enum("Pos", [
					new Double("", $this->x + 0.5),
					new Double("", $this->y),
					new Double("", $this->z + 0.5)
				]),
				"Motion" => new Enum("Motion", [
					new Double("", -sin($mot) * 0.02),
					new Double("", 0.2),
					new Double("", -cos($mot) * 0.02)
				]),
				"Rotation" => new Enum("Rotation", [
					new Float("", 0),
					new Float("", 0)
				]),
				"Fuse" => new Byte("Fuse", 80)
			]));

			$tnt->spawnToAll();

			return true;
		}

		return false;
	}

	public function onRedstoneUpdate($type,$power){
		if($this->isPowered()){
			$this->onActivate(new FlintSteel());
			return;
		}
	}
}