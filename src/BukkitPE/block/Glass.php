<?php
namespace BukkitPE\block;

use BukkitPE\item\Item;

class Glass extends Transparent{

	protected $id = self::GLASS;

	public function __construct(){

	}

	public function getName(){
		return "Glass";
	}

	public function getHardness(){
		return 0.3;
	}

	public function getDrops(Item $item){
		return [];
	}
}