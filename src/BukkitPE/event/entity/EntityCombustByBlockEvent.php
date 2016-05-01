<?php
namespace BukkitPE\event\entity;

use BukkitPE\block\Block;
use BukkitPE\entity\Entity;

class EntityCombustByBlockEvent extends EntityCombustEvent{

	protected $combuster;

	/**
	 * @param Block  $combuster
	 * @param Entity $combustee
	 * @param int    $duration
	 */
	public function __construct(Block $combuster, Entity $combustee, $duration){
		parent::__construct($combustee, $duration);
		$this->combuster = $combuster;
	}

	/**
	 * @return Block
	 */
	public function getCombuster(){
		return $this->combuster;
	}

}