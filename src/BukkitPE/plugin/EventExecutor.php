<?php
namespace BukkitPE\plugin;

use BukkitPE\event\Event;
use BukkitPE\event\Listener;

interface EventExecutor{

	/**
	 * @param Listener $listener
	 * @param Event    $event
	 *
	 * @return void
	 */
	public function execute(Listener $listener, Event $event);
}