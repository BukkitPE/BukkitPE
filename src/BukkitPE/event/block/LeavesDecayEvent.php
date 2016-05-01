<?php
namespace BukkitPE\event\block;

use BukkitPE\block\Block;
use BukkitPE\event\Cancellable;

class LeavesDecayEvent extends BlockEvent implements Cancellable{
	public static $handlerList = null;

	public function __construct(Block $block){
		parent::__construct($block);
	}

}