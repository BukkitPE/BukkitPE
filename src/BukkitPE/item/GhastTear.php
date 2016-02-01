<?php
namespace BukkitPE\item;
class GhastTear extends Item{
	public function __construct($meta = 0, $count = 1){
		parent::__construct(self::GHAST_TEAR, $meta, $count, "Ghast Tear");
	}
}
