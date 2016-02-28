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

class Bedrock extends Solid{

	protected $id = self::BEDROCK;

	public function __construct(){

	}

	public function getName(){
		return "Bedrock";
	}

	public function getHardness(){
		return -1;
	}

	public function getResistance(){
		return 18000000;
	}

	public function isBreakable(Item $item){
		return false;
	}

}
