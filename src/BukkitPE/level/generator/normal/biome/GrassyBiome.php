<?php
namespace BukkitPE\level\generator\normal\biome;

use BukkitPE\block\Block;

abstract class GrassyBiome extends NormalBiome{

	public function __construct(){
		$this->setGroundCover([
			Block::get(Block::GRASS, 0),
			Block::get(Block::DIRT, 0),
			Block::get(Block::DIRT, 0),
			Block::get(Block::DIRT, 0),
			Block::get(Block::DIRT, 0),
		]);
	}
}