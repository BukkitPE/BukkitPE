<?php
namespace BukkitPE\block;

class StillWater extends Water{

	protected $id = self::STILL_WATER;

	public function getName(){
		return "Still Water";
	}
}