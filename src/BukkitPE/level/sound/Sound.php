<?php
namespace BukkitPE\level\sound;

use BukkitPE\math\Vector3;
use BukkitPE\network\protocol\DataPacket;

abstract class Sound extends Vector3{
	
	/**
	 * @return DataPacket|DataPacket[]
	 */
	abstract public function encode();

}
