<?php
namespace BukkitPE\block;

use BukkitPE\entity\Entity;
use BukkitPE\item\Item;
use BukkitPE\level\Level;
use BukkitPE\math\Vector3;
use BukkitPE\nbt\tag\Byte;
use BukkitPE\nbt\tag\Compound;
use BukkitPE\nbt\tag\Double;
use BukkitPE\nbt\tag\Enum;
use BukkitPE\nbt\tag\Float;
use BukkitPE\nbt\tag\Int;
use BukkitPE\Player;

abstract class Fallable extends Solid{

	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		$ret = $this->getLevel()->setBlock($this, $this, true, true);

		return $ret;
	}

	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_NORMAL){
			$down = $this->getSide(Vector3::SIDE_DOWN);
			if($down->getId() === self::AIR or ($down instanceof Liquid)){
				$fall = Entity::createEntity("FallingSand", $this->getLevel()->getChunk($this->x >> 4, $this->z >> 4), new Compound("", [
					"Pos" => new Enum("Pos", [
						new Double("", $this->x + 0.5),
						new Double("", $this->y),
						new Double("", $this->z + 0.5)
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
					"TileID" => new Int("TileID", $this->getId()),
					"Data" => new Byte("Data", $this->getDamage()),
				]));

				$fall->spawnToAll();
			}
		}
	}
}