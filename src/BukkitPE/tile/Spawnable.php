<?php
namespace BukkitPE\tile;

use BukkitPE\level\format\FullChunk;
use BukkitPE\nbt\NBT;
use BukkitPE\nbt\tag\Compound;
use BukkitPE\network\Network;
use BukkitPE\network\protocol\BlockEntityDataPacket;
use BukkitPE\Player;

abstract class Spawnable extends Tile{

	public function spawnTo(Player $player){
		if($this->closed){
			return false;
		}

		$nbt = new NBT(NBT::LITTLE_ENDIAN);
		$nbt->setData($this->getSpawnCompound());
		$pk = new BlockEntityDataPacket();
		$pk->x = $this->x;
		$pk->y = $this->y;
		$pk->z = $this->z;
		$pk->namedtag = $nbt->write();
		$player->dataPacket($pk);

		return true;
	}

	/**
	 * @return Compound
	 */
	public abstract function getSpawnCompound();

	public function __construct(FullChunk $chunk, Compound $nbt){
		parent::__construct($chunk, $nbt);
		$this->spawnToAll();
	}

	public function spawnToAll(){
		if($this->closed){
			return;
		}

		foreach($this->getLevel()->getChunkPlayers($this->chunk->getX(), $this->chunk->getZ()) as $player){
			if($player->spawned === true){
				$this->spawnTo($player);
			}
		}
	}
}
