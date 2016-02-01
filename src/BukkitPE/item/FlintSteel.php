<?php
namespace BukkitPE\item;

use BukkitPE\block\Block;
use BukkitPE\block\Fire;
use BukkitPE\block\Solid;
use BukkitPE\level\Level;
use BukkitPE\Player;

class FlintSteel extends Tool{
	public function __construct($meta = 0, $count = 1){
		parent::__construct(self::FLINT_STEEL, $meta, $count, "Flint and Steel");
	}

	public function canBeActivated(){
		return true;
	}

	public function onActivate(Level $level, Player $player, Block $block, Block $target, $face, $fx, $fy, $fz){
		if(($player->gamemode & 0x01) === 0 and $this->useOn($block) and $this->getDamage() >= $this->getMaxDurability()){
			$player->getInventory()->setItemInHand(new Item(Item::AIR, 0, 0));
		}

		if($block->getId() === self::AIR and ($target instanceof Solid)){
			$level->setBlock($block, new Fire(), true);

			return true;
		}

		return false;
	}
}