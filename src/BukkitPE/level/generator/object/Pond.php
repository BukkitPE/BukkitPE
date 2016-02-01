<?php
namespace BukkitPE\level\generator\object;

use BukkitPE\block\Block;
use BukkitPE\level\ChunkManager;
use BukkitPE\math\Vector3 as Vector3;
use BukkitPE\utils\Random;

class Pond{
	private $random;
	public $type;

	public function __construct(Random $random, Block $type){
		$this->type = $type;
		$this->random = $random;
	}

	public function canPlaceObject(ChunkManager $level, Vector3 $pos){
	}

	public function placeObject(ChunkManager $level, Vector3 $pos){
	}

}