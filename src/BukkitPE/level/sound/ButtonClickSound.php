<?php
namespace BukkitPE\level\sound;

use BukkitPE\math\Vector3;
use BukkitPE\network\protocol\LevelEventPacket;

class ButtonClickSound extends GenericSound{
    public function __construct(Vector3 $pos, $pitch = 1000){
        parent::__construct($pos, LevelEventPacket::EVENT_SOUND_BUTTON_CLICK, $pitch);
    }
}