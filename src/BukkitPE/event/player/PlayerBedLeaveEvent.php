<?php
namespace BukkitPE\event\player;

use BukkitPE\block\Block;
use BukkitPE\Player;

class PlayerBedLeaveEvent extends PlayerEvent{
	public static $handlerList = null;

	private $bed;

	public function __construct(Player $player, Block $bed){
		$this->player = $player;
		$this->bed = $bed;
	}

	public function getBed(){
		return $this->bed;
	}

}