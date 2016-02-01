<?php
namespace BukkitPE\level\sound;

use BukkitPE\math\Vector3;
use BukkitPE\network\protocol\LevelEventPacket;

class DoorBumpSound extends GenericSound{
	public function __construct(Vector3 $pos, $pitch = 0){
		parent::__construct($pos, LevelEventPacket::EVENT_SOUND_DOOR_BUMP, $pitch);
	}
}
