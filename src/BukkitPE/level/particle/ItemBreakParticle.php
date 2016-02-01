<?php
namespace BukkitPE\level\particle;

use BukkitPE\math\Vector3;
use BukkitPE\item\Item;

class ItemBreakParticle extends GenericParticle{
	public function __construct(Vector3 $pos, Item $item){
		parent::__construct($pos, Particle::TYPE_ITEM_BREAK, ($item->getId() << 16) | $item->getDamage());
	}
}
