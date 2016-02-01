<?php
namespace BukkitPE\level\generator\object;

use BukkitPE\block\Block;
use BukkitPE\level\ChunkManager;
use BukkitPE\math\Vector3 as Vector3;
use BukkitPE\utils\Random;

class TallGrass{
	public static function growGrass(ChunkManager $level, Vector3 $pos, Random $random, $count = 15, $radius = 10){
		$arr = [
			[Block::DANDELION, 0],
			[Block::POPPY, 0],
			[Block::TALL_GRASS, 1],
			[Block::TALL_GRASS, 1],
			[Block::TALL_GRASS, 1],
			[Block::TALL_GRASS, 1]
		];
		$arrC = count($arr) - 1;
		for($c = 0; $c < $count; ++$c){
			$x = $random->nextRange($pos->x - $radius, $pos->x + $radius);
			$z = $random->nextRange($pos->z - $radius, $pos->z + $radius);
			if($level->getBlockIdAt($x, $pos->y + 1, $z) === Block::AIR and $level->getBlockIdAt($x, $pos->y, $z) === Block::GRASS){
				$t = $arr[$random->nextRange(0, $arrC)];
				$level->setBlockIdAt($x, $pos->y + 1, $z, $t[0]);
				$level->setBlockDataAt($x, $pos->y + 1, $z, $t[1]);
			}
		}
	}
}