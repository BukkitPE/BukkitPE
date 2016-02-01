<?php
namespace BukkitPE\event\level;

use BukkitPE\event\Cancellable;

/**
 * Called when a Chunk is unloaded
 */
class ChunkUnloadEvent extends ChunkEvent implements Cancellable{
	public static $handlerList = null;
}