<?php
namespace BukkitPE\event\block;

use BukkitPE\block\Block;
use BukkitPE\event\Cancellable;
use BukkitPE\item\Item;
use BukkitPE\Player;

class BlockBreakEvent extends BlockEvent implements Cancellable{
	public static $handlerList = null;

	/** @var \BukkitPE\Player */
	protected $player;

	/** @var \BukkitPE\item\Item */
	protected $item;

	/** @var bool */
	protected $instaBreak = false;
	protected $blockDrops = [];

	public function __construct(Player $player, Block $block, Item $item, $instaBreak = false){
		$this->block = $block;
		$this->item = $item;
		$this->player = $player;
		$this->instaBreak = (bool) $instaBreak;
		$drops = $player->isSurvival() ? $block->getDrops($item) : [];
		foreach($drops as $i){
			$this->blockDrops[] = Item::get($i[0], $i[1], $i[2]);
		}
	}

	public function getPlayer(){
		return $this->player;
	}

	public function getItem(){
		return $this->item;
	}

	public function getInstaBreak(){
		return $this->instaBreak;
	}

	/**
	 * @return Item[]
	 */
	public function getDrops(){
		return $this->blockDrops;
	}

	/**
	 * @param Item[] $drops
	 */
	public function setDrops(array $drops){
		$this->blockDrops = $drops;
	}

	/**
	 * @param boolean $instaBreak
	 */
	public function setInstaBreak($instaBreak){
		$this->instaBreak = (bool) $instaBreak;
	}
}
