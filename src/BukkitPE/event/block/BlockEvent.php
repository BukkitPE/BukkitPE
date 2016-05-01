<?php
/**
 * Block related events
 */
namespace BukkitPE\event\block;

use BukkitPE\block\Block;
use BukkitPE\event\Event;

abstract class BlockEvent extends Event{
	/** @var \BukkitPE\block\Block */
	protected $block;

	/**
	 * @param Block $block
	 */
	public function __construct(Block $block){
		$this->block = $block;
	}

	/**
	 * @return Block
	 */
	public function getBlock(){
		return $this->block;
	}
}