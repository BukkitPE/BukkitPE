<?php
namespace BukkitPE\event\player;

use BukkitPE\event\Cancellable;
use BukkitPE\Player;

/**
 * Called when a player has its gamemode changed
 */
class PlayerGameModeChangeEvent extends PlayerEvent implements Cancellable{
	public static $handlerList = null;

	/** @var int */
	protected $gamemode;

	public function __construct(Player $player, $newGamemode){
		$this->player = $player;
		$this->gamemode = (int) $newGamemode;
	}

	public function getNewGamemode(){
		return $this->gamemode;
	}

}