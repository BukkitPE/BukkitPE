<?php
namespace BukkitPE\event\server;

use BukkitPE\event;
use BukkitPE\event\Cancellable;
use BukkitPE\network\protocol\DataPacket;
use BukkitPE\Player;

class DataPacketReceiveEvent extends ServerEvent implements Cancellable{
	public static $handlerList = null;

	private $packet;
	private $player;

	public function __construct(Player $player, DataPacket $packet){
		$this->packet = $packet;
		$this->player = $player;
	}

	public function getPacket(){
		return $this->packet;
	}

	public function getPlayer(){
		return $this->player;
	}
}