<?php
namespace BukkitPE\event\block;

use BukkitPE\block\Block;
use BukkitPE\event\Cancellable;

class BlockFormEvent extends BlockGrowEvent implements Cancellable{
	public static $handlerList = null;

	public function __construct(Block $block, Block $newState){
		parent::__construct($block, $newState);
	}

}