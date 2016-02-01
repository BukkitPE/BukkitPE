<?php
namespace BukkitPE\item;

use BukkitPE\block\Block;

class StringItem extends Item{
	public function __construct($meta = 0, $count = 1){
		$this->block = Block::get(Item::TRIPWIRE);
		parent::__construct(self::STRING, $meta, $count, "String");
	}

}

