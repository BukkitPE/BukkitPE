<?php
namespace BukkitPE\level\particle;

use BukkitPE\math\Vector3;

class InkParticle extends GenericParticle{
	public function __construct(Vector3 $pos, $scale = 0){
		parent::__construct($pos, Particle::TYPE_INK, $scale);
	}
}
