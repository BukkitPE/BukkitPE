<?php

namespace BukkitPE\item;

abstract class Armor extends Item{

	public function getMaxStackSize(){
		return 1;
	}
}