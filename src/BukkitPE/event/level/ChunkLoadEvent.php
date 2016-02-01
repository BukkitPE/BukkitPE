<?php
namespace BukkitPE\event\level;

use BukkitPE\level\format\FullChunk;

/**
 * Called when a Chunk is loaded
 */
class ChunkLoadEvent extends ChunkEvent{
	public static $handlerList = null;

	private $newChunk;

	public function __construct(FullChunk $chunk, $newChunk){
		parent::__construct($chunk);
		$this->newChunk = (bool) $newChunk;
	}

	/**
	 * @return bool
	 */
	public function isNewChunk(){
		return $this->newChunk;
	}
}