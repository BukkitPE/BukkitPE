<?php
namespace BukkitPE\level\particle;

use BukkitPE\math\Vector3;

class EnchantmentTableParticle extends GenericParticle{
	public function __construct(Vector3 $pos){
		parent::__construct($pos, Particle::TYPE_ENCHANTMENT_TABLE);
	}
}
