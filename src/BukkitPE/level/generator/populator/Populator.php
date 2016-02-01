<?php
/**
 * All the Object populator classes
 */
namespace BukkitPE\level\generator\populator;

use BukkitPE\level\ChunkManager;
use BukkitPE\utils\Random;

abstract class Populator{
	public abstract function populate(ChunkManager $level, $chunkX, $chunkZ, Random $random);
}