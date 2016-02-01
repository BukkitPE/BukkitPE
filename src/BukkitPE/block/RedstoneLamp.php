<?php
namespace BukkitPE\block;

use BukkitPE\item\Tool;
use BukkitPE\item\Item;
use BukkitPE\level\Level;
use BukkitPE\Player;

class RedstoneLamp extends Solid implements Redstone,RedstoneConsumer{

	protected $id = self::REDSTONE_LAMP;

	public function __construct(){

	}
	
	public function getToolType(){
		return Tool::TYPE_PICKAXE;
	}
	
	
	
	public function onRedstoneUpdate($type, $power){
		if($this->isStrongCharged()){
			$this->id = 124;
			$this->getLevel()->setBlock($this, $this);
			$this->BroadcastRedstoneUpdate(Level::REDSTONE_UPDATE_BLOCK,null);
			return;
		}
		if($this->isPowered()){
			$this->id = 124;
			$this->getLevel()->setBlock($this, $this);
			return;
		}
	}

	public function getName(){
		return "Redstone Lamp";
	}

	public function getHardness(){
		return 0.3;
	}
}
