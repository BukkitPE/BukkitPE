<?php
/**
 * Player-only related events
 */
namespace BukkitPE\event\player;

use BukkitPE\event\Event;

abstract class PlayerEvent extends Event{
	/** @var \BukkitPE\Player */
	protected $player;

	public function getPlayer(){
		return $this->player;
	}
}