<?php
namespace BukkitPE\item;
class RabbitFoot extends Item{
	public function __construct($meta = 0, $count = 1){
		parent::__construct(self::RABBIT_FOOT, $meta, $count, "Rabbit Foot");
	}
}
