<?php
/**
 * Events related Plugin enable / disable events
 */
namespace BukkitPE\event\plugin;

use BukkitPE\event\Event;
use BukkitPE\plugin\Plugin;


abstract class PluginEvent extends Event{

	/** @var Plugin */
	private $plugin;

	public function __construct(Plugin $plugin){
		$this->plugin = $plugin;
	}

	/**
	 * @return Plugin
	 */
	public function getPlugin(){
		return $this->plugin;
	}
}
