<?php
namespace BukkitPE\level\sound;

use BukkitPE\math\Vector3;
use BukkitPE\network\protocol\LevelEventPacket;

class BlazeShootSound extends GenericSound{
	public function __construct(Vector3 $pos, $pitch = 0){
		parent::__construct($pos, LevelEventPacket::EVENT_SOUND_BLAZE_SHOOT, $pitch);
	}
}
