<?php
/**
 * Level related events
 */
namespace BukkitPE\event\level;

use BukkitPE\event\Event;
use BukkitPE\level\Level;

abstract class LevelEvent extends Event{
	/** @var \BukkitPE\level\Level */
	private $level;

	/**
	 * @param Level $level
	 */
	public function __construct(Level $level){
		$this->level = $level;
	}

	/**
	 * @return \BukkitPE\level\Level
	 */
	public function getLevel(){
		return $this->level;
	}
}