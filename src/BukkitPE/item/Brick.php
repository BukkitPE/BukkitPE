<?php
namespace BukkitPE\item;


class Brick extends Item{
	public function __construct($meta = 0, $count = 1){
		parent::__construct(self::BRICK, 0, $count, "Brick");
	}

}