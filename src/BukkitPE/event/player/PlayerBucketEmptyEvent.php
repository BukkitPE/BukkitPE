<?php
namespace BukkitPE\event\player;

use BukkitPE\block\Block;
use BukkitPE\item\Item;
use BukkitPE\Player;

class PlayerBucketEmptyEvent extends PlayerBucketEvent{
	public static $handlerList = null;

	public function __construct(Player $who, Block $blockClicked, $blockFace, Item $bucket, Item $itemInHand){
		parent::__construct($who, $blockClicked, $blockFace, $bucket, $itemInHand);
	}
}