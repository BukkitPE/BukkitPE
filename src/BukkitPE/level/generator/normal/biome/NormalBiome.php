<?php
namespace BukkitPE\level\generator\normal\biome;

use BukkitPE\level\generator\biome\Biome;

abstract class NormalBiome extends Biome{

	public function getColor(){
		return $this->grassColor;
	}
}
