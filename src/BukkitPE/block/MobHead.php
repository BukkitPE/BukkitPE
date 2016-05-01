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
 use BukkitPE\level\Level;
 use BukkitPE\nbt\tag\Byte;
 use BukkitPE\nbt\tag\Compound;
 use BukkitPE\nbt\tag\Int;
 use BukkitPE\nbt\tag\String;
 use BukkitPE\Player;
 use BukkitPE\tile\Spawnable;
 use BukkitPE\tile\Tile;
 
 class MobHead extends Solid{
 	protected $id = self::MOB_HEAD;
 	protected $type;
 
 	public function __construct($meta = 0){
 		$this->meta = $meta;
 	}
 
 	public function getHardness(){
 		return 1;
 	}
 
 	public function getName(){
 		return "Mob Head";
 	}
 
 	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
 		if($face !== 0){
 			$this->meta = $face;
 			if($face === 1){
 				$rot = floor(($player->yaw * 16 / 360)  0.5) & 0x0F;
 			}else{
 				$rot = $face;
 			}
 			$this->getLevel()->setBlock($block, $this, true);
 			$nbt = new Compound("", [
 				new String("id", Tile::SKULL),
 				new Byte("SkullType", $item->getDamage()),
 				new Byte("Rot",  $rot),
 				new Int("x", (int) $this->x),
 				new Int("y", (int) $this->y),
 				new Int("z", (int) $this->z)
 			]);
 			if($item->hasCustomName()){
 				$nbt->CustomName = new String("CustomName", $item->getCustomName());
 			}
 			/** @var Spawnable $tile */
 			Tile::createTile("Skull", $this->getLevel()->getChunk($this->x >> 4, $this->z >> 4), $nbt);
 			return true;
 		}
 		return false;
 	}
 
 	public function onUpdate($type){
 		parent::onUpdate($type);
 		$faces = [
 			1 => 0,
 			2 => 3,
 			3 => 2,
 			4 => 5,
 			5 => 4,
 		];
 		if($type === Level::BLOCK_UPDATE_NORMAL){
 			if($this->getSide($faces[$this->meta])->getId() === self::AIR){
 				$this->getLevel()->useBreakOn($this);
 
 				return Level::BLOCK_UPDATE_NORMAL;
 			}
 		}
 
 		return false;
 	}
 
 	public function getDrops(Item $item){
 		if($this->meta === 3){
 			return [];
 		}
 		return [
 			[Item::MOB_HEAD, $this->type, 1]
 		];
 	}
 } with and functions-in Client Side JavaScripting, so only your computer will see or process your data input/output.
