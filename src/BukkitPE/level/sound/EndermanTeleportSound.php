<?php
namespace BukkitPE\level\sound;

use BukkitPE\math\Vector3;
use BukkitPE\network\protocol\LevelEventPacket;

class EndermanTeleportSound extends GenericSound{
	public function __construct(Vector3 $pos){
		parent::__construct($pos, LevelEventPacket::EVENT_SOUND_ENDERMAN_TELEPORT);
	}
}
