<?php
namespace BukkitPE\event\level;

use BukkitPE\event\Cancellable;

/**
 * Called when a Level is unloaded
 */
class LevelUnloadEvent extends LevelEvent implements Cancellable{
	public static $handlerList = null;
}