<?php
namespace BukkitPE\level\generator\object;

use BukkitPE\block\Block;
use BukkitPE\block\Wood;
use BukkitPE\level\ChunkManager;
use BukkitPE\utils\Random;

class OakTree extends Tree{

	public function __construct(){
		$this->trunkBlock = Block::LOG;
		$this->leafBlock = Block::LEAVES;
		$this->type = Wood::OAK;
	}

	public function placeObject(ChunkManager $level, $x, $y, $z, Random $random){
		$this->treeHeight = $random->nextBoundedInt(3) + 4;
		parent::placeObject($level, $x, $y, $z, $random);
	}
}