<?php
namespace BukkitPE\event\block;

use BukkitPE\block\Block;
use BukkitPE\event\Cancellable;
use BukkitPE\item\Item;
use BukkitPE\Player;

/**
 * Called when a player places a block
 */
class BlockPlaceEvent extends BlockEvent implements Cancellable{
	public static $handlerList = null;

	/** @var \BukkitPE\Player */
	protected $player;

	/** @var \BukkitPE\item\Item */
	protected $item;


	protected $blockReplace;
	protected $blockAgainst;

	public function __construct(Player $player, Block $blockPlace, Block $blockReplace, Block $blockAgainst, Item $item){
		$this->block = $blockPlace;
		$this->blockReplace = $blockReplace;
		$this->blockAgainst = $blockAgainst;
		$this->item = $item;
		$this->player = $player;
	}

	public function getPlayer(){
		return $this->player;
	}

	/**
	 * Gets the item in hand
	 *
	 * @return mixed
	 */
	public function getItem(){
		return $this->item;
	}

	public function getBlockReplaced(){
		return $this->blockReplace;
	}

	public function getBlockAgainst(){
		return $this->blockAgainst;
	}
}