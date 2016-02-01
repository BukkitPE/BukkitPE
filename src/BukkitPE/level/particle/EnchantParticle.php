<?php
namespace BukkitPE\level\particle;

use BukkitPE\math\Vector3;

class EnchantParticle extends GenericParticle{
	public function __construct(Vector3 $pos){
		parent::__construct($pos, Particle::TYPE_MOB_SPELL);
	}
}
