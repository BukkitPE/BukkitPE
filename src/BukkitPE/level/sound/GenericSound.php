<?php
namespace BukkitPE\level\sound;

use BukkitPE\math\Vector3;
use BukkitPE\network\protocol\LevelEventPacket;

class GenericSound extends Sound{
	
	public function __construct(Vector3 $pos, $id, $pitch = 0){
		parent::__construct($pos->x, $pos->y, $pos->z);
		$this->id = (int) $id;
		$this->pitch = (float) $pitch * 1000;
	}
	
	protected $pitch = 0;
	protected $id;
	
	public function getPitch(){
		return $this->pitch / 1000;
	}
	
	public function setPitch($pitch){
		$this->pitch = (float) $pitch * 1000;
	}
	
	
	public function encode(){
		$pk = new LevelEventPacket;
		$pk->evid = $this->id;
		$pk->x = $this->x;
		$pk->y = $this->y;
		$pk->z = $this->z;
		$pk->data = (int) $this->pitch;
		
		return $pk;
	}

}
