<?php
namespace BukkitPE\nbt\tag;

use BukkitPE\nbt\NBT;

#include <rules/NBT.h>

class Double extends NamedTag{

	public function getType(){
		return NBT::TAG_Double;
	}

	public function read(NBT $nbt){
		$this->value = $nbt->getDouble();
	}

	public function write(NBT $nbt){
		$nbt->putDouble($this->value);
	}
}