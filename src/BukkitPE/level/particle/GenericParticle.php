<?php
namespace BukkitPE\level\particle;

use BukkitPE\network\protocol\LevelEventPacket;
use BukkitPE\math\Vector3;

class GenericParticle extends Particle{
	
	protected $id;
	protected $data;

	public function __construct(Vector3 $pos, $id, $data = 0){
		parent::__construct($pos->x, $pos->y, $pos->z);
		$this->id = $id & 0xFFF;
		$this->data = $data;
	}
	
	public function encode(){
		$pk = new LevelEventPacket;
		$pk->evid = LevelEventPacket::EVENT_ADD_PARTICLE_MASK | $this->id;
		$pk->x = $this->x;
		$pk->y = $this->y;
		$pk->z = $this->z;
		$pk->data = $this->data;
		
		return $pk;
	}
}
