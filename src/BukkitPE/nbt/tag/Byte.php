<?php
namespace BukkitPE\nbt\tag;

use BukkitPE\nbt\NBT;

#include <rules/NBT.h>

class Byte extends NamedTag{

	public function getType(){
		return NBT::TAG_Byte;
	}

	public function read(NBT $nbt){
		$this->value = $nbt->getByte();
	}

	public function write(NBT $nbt){
		$nbt->putByte($this->value);
	}
}