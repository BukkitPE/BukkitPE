<?php
namespace BukkitPE\level\particle;

use BukkitPE\math\Vector3;

class HugeExplodeParticle extends GenericParticle{
	public function __construct(Vector3 $pos){
		parent::__construct($pos, Particle::TYPE_HUGE_EXPLODE);
	}
}
