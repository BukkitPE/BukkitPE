<?php
namespace BukkitPE\item;

use BukkitPE\nbt\tag\Enum;
use BukkitPE\nbt\tag\Double;
use BukkitPE\nbt\tag\Float;
use BukkitPE\nbt\tag\Byte;
use BukkitPE\nbt\tag\Compound;
use BukkitPE\entity\Entity;
use BukkitPE\Player;

abstract class Launchable extends Item{
	public function launch(Player $player){
		$dir = $player->getDirectionVector();
 		$frontPos = $player->add($dir->multiply(1.1));
 		$nbt = new Compound("", [
							"Pos" => new Enum("Pos", [new Double("", $frontPos->x),new Double("", $frontPos->y + $player->getEyeHeight()),new Double("", $frontPos->z)]),
 							"Motion" => new Enum("Motion", [new Double("", $dir->x),new Double("", $dir->y),new Double("", $dir->z)]),
							"Rotation" => new Enum("Rotation", [new Float("", 0),new Float("", 0)]),
							"Data" => new Byte("Data", $this->getDamage()),
							]);
		$f = $this->f;
		$launched = Entity::createEntity($this->getEntityName(), $player->chunk, $nbt);
		$launched->setMotion($launched->getMotion()->multiply($f));
		if($launched instanceof Projectile){
			$player->server->getPluginManager()->callEvent($projectileEv = new ProjectileLaunchEvent($launched));
			if($projectileEv->isCancelled()){
				$launched->kill();
			}else{
				$launched->spawnToAll();
				$player->level->addSound(new LaunchSound($player), $player->getViewers());
			}
		}else{
			$launched->spawnToAll();
		}
	}
}