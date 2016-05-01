<?php
namespace BukkitPE\level\generator\object;

use BukkitPE\block\Block;
use BukkitPE\block\Wood;

class JungleTree extends Tree{

	public function __construct(){
		$this->trunkBlock = Block::LOG;
		$this->leafBlock = Block::LEAVES;
		$this->type = Wood::JUNGLE;
		$this->treeHeight = 8;
	}
}