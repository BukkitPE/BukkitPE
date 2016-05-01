<?php
/*
 * THIS IS COPIED FROM THE PLUGIN FlowerPot MADE BY @beito123!!
 * https://github.com/beito123/BukkitPE-MP-Plugins/blob/master/test%2FFlowerPot%2Fsrc%2Fbeito%2FFlowerPot%2Fomake%2FSkull.php
 * 
 */

namespace BukkitPE\block;

use BukkitPE\item\Item;
use BukkitPE\item\Tool;

use BukkitPE\math\Vector3;
use BukkitPE\nbt\tag\Compound;
use BukkitPE\nbt\tag\Int;
use BukkitPE\nbt\tag\String;
use BukkitPE\Player;
use BukkitPE\tile\Tile;
use BukkitPE\math\AxisAlignedBB;
use BukkitPE\nbt\tag\Byte;
use BukkitPE\tile\Skull;

class SkullBlock extends Transparent{

	protected $id = self::SKULL_BLOCK;

	public function __construct($meta = 0){
		$this->meta = $meta;
	}

	public function getHardness(){
		return 1;
	}

	public function isSolid(){
		return false;
	}

	public function getBoundingBox(){
		return new AxisAlignedBB(
			$this->x - 0.75,
			$this->y - 0.5,
			$this->z - 0.75,
			$this->x + 0.75,
			$this->y + 0.5,
			$this->z + 0.75
		);
	}

	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		$down = $this->getSide(0);
		if($face !== 0 && $fy > 0.5 && $target->getId() !== self::SKULL_BLOCK && !$down instanceof SkullBlock){
			$this->getLevel()->setBlock($block, Block::get(Block::SKULL_BLOCK, 0), true, true);
			if($face === 1){
				$rot = new Byte("Rot", floor(($player->yaw * 16 / 360) + 0.5) & 0x0F);
			}
			else{
				$rot = new Byte("Rot", 0);
			}
			$nbt = new Compound("", [
				new String("id", Tile::SKULL),
				new Int("x", $block->x),
				new Int("y", $block->y),
				new Int("z", $block->z),
				new Byte("SkullType", $item->getDamage()),
				$rot
			]);

			$chunk = $this->getLevel()->getChunk($this->x >> 4, $this->z >> 4);
			$pot = Tile::createTile("Skull", $chunk, $nbt);
			$this->getLevel()->setBlock($block, Block::get(Block::SKULL_BLOCK, $face), true, true);
			return true;
		}
		return false;
	}

	public function getResistance(){
		return 5;
	}

	public function getName(){
		static $names = [
			0 => "Skeleton Skull",
			1 => "Wither Skeleton Skull",
			2 => "Zombie Head",
			3 => "Head",
			4 => "Creeper Head"
		];
		return $names[$this->meta & 0x04];
	}

	public function getToolType(){
		return Tool::TYPE_PICKAXE;
	}

	public function onBreak(Item $item){
		$this->getLevel()->setBlock($this, new Air(), true, true, true);
		return true;
	}

	public function getDrops(Item $item){
		if(($tile = $this->getLevel()->getTile($this)) instanceof Skull){
			return [[Item::SKULL,$tile->getSkullType(),1]];
		}
		else
			return [[Item::SKULL,0,1]];
	}
}