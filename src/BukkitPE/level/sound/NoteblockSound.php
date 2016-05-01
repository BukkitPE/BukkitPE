<?php
namespace BukkitPE\level\sound;

use BukkitPE\math\Vector3;
use BukkitPE\network\protocol\BlockEventPacket;
use BukkitPE\network\protocol\LevelEventPacket;
use BukkitPE\block\Block;

class NoteblockSound extends GenericSound{
	protected $instrument;
	protected $pitch;

	// Piano or Harp :  Any other material
	const INSTRUMENT_PIANO = 0;
	// Bass Drum : Stone, SandStone, Ores, Brick, NetherRack, Opsidian, Quartz
	const INSTRUMENT_BASS_DRUM = 1;
	// Snare Drum : Sand, Gravel, SoulSand
	const INSTRUMENT_TABOUR = 2;
	// Clicks and Sticks : Glass, GlowStone
	const INSTRUMENT_CLICK = 3;
	// Bass guitar : Wood, Mushroom, Daylight Sensor, Wooden plate
	const INSTRUMENT_BASS = 4;

	public static function getInstrument(Block $block){
		switch($block->getID()){
			case Block::STONE:
			case Block::COBBLESTONE:
			case Block::COBBLE_STAIRS:
			case Block::BEDROCK:
 			case Block::GOLD_ORE:
			case Block::IRON_ORE:
			case Block::COAL_ORE:
			case Block::LAPIS_ORE:
			case Block::DIAMOND_ORE:
			case Block::REDSTONE_ORE:
			case Block::EMERALD_ORE:
 			case Block::GLOWING_REDSTONE_ORE:
			case Block::FURNACE:
			case Block::BURNING_FURNACE:
			case Block::BRICKS:
			case Block::BRICK_STAIRS:
			case Block::STONE_BRICK:
			case Block::STONE_BRICK_STAIRS:
			case Block::NETHERRACK:
			case Block::COBBLE_WALL:
			case Block::STONECUTTER:
			case Block::MOSS_STONE:
			case Block::OBSIDIAN:
			case Block::SANDSTONE:
			case Block::END_STONE:
			case Block::MONSTER_SPAWNER:
 			case Block::END_PORTAL_FRAME:
 			case Block::QUARTZ_BLOCK:
			case Block::QUARTZ_STAIRS:
			case Block::NETHER_BRICKS:
			case Block::NETHER_BRICKS_STAIRS:
			case Block::ENCHANT_TABLE:
 			case Block::STONE_PRESSURE_PLATE:
				return self::INSTRUMENT_BASS_DRUM;
			break;
 			case Block::SAND:
			case Block::GRAVEL:
			case Block::SOUL_SAND:
				return self::INSTRUMENT_TABOUR;
			break;
			case Block::GLASS:
			case Block::GLASS_PANEL:
			case Block::GLOWSTONE:
 				return self::INSTRUMENT_CLICK;
			break;
			case Block::WOOD:
			case Block::WOOD2:
			case Block::PLANK:
			case Block::SPRUCE_WOOD_STAIRS:
			case Block::BIRCH_WOOD_STAIRS:
			case Block::JUNGLE_WOOD_STAIRS:
			case Block::DOUBLE_WOOD_SLAB:
			case Block::ACACIA_WOOD_STAIRS:
			case Block::DARK_OAK_WOOD_STAIRS:
			case Block::WOOD_STAIRS:
			case Block::BOOKSHELF:
			case Block::CHEST:
			case Block::WORKBENCH:
			case Block::SIGN_POST:
			case Block::WALL_SIGN:
			case Block::WOOD_DOOR_BLOCK:
			case Block::SPRUCE_DOOR_BLOCK:
			case Block::BIRCH_DOOR_BLOCK:
			case Block::JUNGLE_DOOR_BLOCK:
			case Block::ACACIA_DOOR_BLOCK:
			case Block::DARK_OAK_DOOR_BLOCK:
			case Block::TRAPDOOR:
			case Block::FENCE:
			case Block::FENCE_GATE:
			case Block::FENCE_GATE_SPRUCE:
			case Block::FENCE_GATE_BIRCH:
			case Block::FENCE_GATE_JUNGLE:
			case Block::FENCE_GATE_DARK_OAK:
			case Block::FENCE_GATE_ACACIA:
			case Block::WOOD_SLAB:
			case Block::BROWN_MUSHROOM:
			case Block::RED_MUSHROOM:
			case Block::NOTEBLOCK:
			case Block::WOODEN_PRESSURE_PLATE:
			case Block::DAYLIGHT_DETECTOR:
			case Block::DAYLIGHT_DETECTOR_INVERTED:
				return self::INSTRUMENT_BASS;
			break;
			case Block::SLAB:
			case Block::DOUBLE_SLAB:
				if($block->getDamage() == 2){ // Wooden Slab
					reuturn self::INSTRUMENT_BASS;
				}else{ // else : Stones
					return self::INSTRUMENT_BASS_DRUM;
				}
			break;
			default:
				return INSTRUMENT_PIANO;
			break;
		}
	}
	

	public function __construct(Vector3 $pos, $instrument = self::INSTRUMENT_PIANO, $pitch = 0){
		parent::__construct($pos, 0);
		$this->instrument = $instrument;
		$this->pitch = $pitch;
	}

	public function encode(){
		$pk = new BlockEventPacket();
		$pk->x = $this->x;
		$pk->y = $this->y;
		$pk->z = $this->z;
		$pk->case1 = $this->instrument;
		$pk->case2 = $this->pitch;

		return $pk;
	}
}