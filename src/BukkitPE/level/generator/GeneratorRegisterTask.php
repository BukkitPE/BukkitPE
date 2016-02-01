<?php
namespace BukkitPE\level\generator;

use BukkitPE\block\Block;

use BukkitPE\level\generator\biome\Biome;
use BukkitPE\level\Level;
use BukkitPE\level\SimpleChunkManager;
use BukkitPE\scheduler\AsyncTask;

use BukkitPE\utils\Random;

class GeneratorRegisterTask extends AsyncTask{

	public $generator;
	public $settings;
	public $seed;
	public $levelId;

	public function __construct(Level $level, Generator $generator){
		$this->generator = get_class($generator);
		$this->settings = $generator->getSettings();
		$this->seed = $level->getSeed();
		$this->levelId = $level->getId();
	}

	public function onRun(){
		Block::init();
		Biome::init();
		$manager = new SimpleChunkManager($this->seed);
		$this->saveToThreadStore("generation.level{$this->levelId}.manager", $manager);
		/** @var Generator $generator */
		$generator = $this->generator;
		$generator = new $generator($this->settings);
		$generator->init($manager, new Random($manager->getSeed()));
		$this->saveToThreadStore("generation.level{$this->levelId}.generator", $generator);
	}
}
