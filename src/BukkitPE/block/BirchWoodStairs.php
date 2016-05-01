<?php
/*
 *
 * ____        _    _    _ _   _____  ______ 
 * |  _ \      | |  | |  (_) | |  __ \|  ____|
 * | |_) |_   _| | _| | ___| |_| |__) | |__   
 * |  _ <| | | | |/ / |/ / | __|  ___/|  __|  
 * | |_) | |_| |   <|   <| | |_| |    | |____ 
 * |____/ \__,_|_|\_\_|\_\_|\__|_|    |______|
 *                                           
 *                                          
 *
 * This program is free software, and it's under the  Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 , You can modify. But 
 * you may not use the material for commercial purposes. 
 *
 * @author BukkitPE Team
 * @link http://www.bukkitpe.net/
 *
 *
*/

namespace BukkitPE\block;

use BukkitPE\item\Item;
use BukkitPE\item\Tool;

class BirchWoodStairs extends Stair{

	protected $id = self::BIRCH_WOOD_STAIRS;

	public function __construct($meta = 0){
		$this->meta = $meta;
	}

	public function getName(){
		return "Birch Wood Stairs";
	}

	public function getDrops(Item $item){
		return [
			[$this->id, 0, 1],
		];
	}

	public function getHardness(){
		return 2;
	}

	public function getResistance(){
		return 15;
	}

	public function getToolType(){
		return Tool::TYPE_AXE;
	}
}
