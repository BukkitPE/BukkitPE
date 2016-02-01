<?php
namespace BukkitPE\event\player;

use BukkitPE\event\entity\EntityDeathEvent;
use BukkitPE\event\TextContainer;
use BukkitPE\item\Item;
use BukkitPE\Player;

class PlayerDeathEvent extends EntityDeathEvent{
	public static $handlerList = null;

	/** @var TextContainer|string */
	private $deathMessage;
	private $keepInventory = false;

	/**
	 * @param Player $entity
	 * @param Item[] $drops
	 * @param string|TextContainer $deathMessage
	 */
	public function __construct(Player $entity, array $drops, $deathMessage){
		parent::__construct($entity, $drops);
		$this->deathMessage = $deathMessage;


	}

	/**
	 * @return Player
	 */
	public function getEntity(){
		return $this->entity;
	}

	/**
	 * @return TextContainer|string
	 */
	public function getDeathMessage(){
		return $this->deathMessage;
	}

	/**
	 * @param string|TextContainer $deathMessage
	 */
	public function setDeathMessage($deathMessage){
		$this->deathMessage = $deathMessage;
	}

	public function getKeepInventory(){
		return $this->keepInventory;
	}

	public function setKeepInventory($keepInventory){
		$this->keepInventory = (bool) $keepInventory;
	}

}