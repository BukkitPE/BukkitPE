<?php
namespace BukkitPE\level\particle;

use BukkitPE\block\Block;
use BukkitPE\math\Vector3;

class TerrainParticle extends GenericParticle{
	public function __construct(Vector3 $pos, Block $b){
		parent::__construct($pos, Particle::TYPE_TERRAIN, ($b->getDamage() << 8) | $b->getId());
	}
}
