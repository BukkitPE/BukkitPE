<?php
namespace BukkitPE\plugin;

use BukkitPE\event\Event;
use BukkitPE\event\Listener;

class MethodEventExecutor implements EventExecutor{

	private $method;

	public function __construct($method){
		$this->method = $method;
	}

	public function execute(Listener $listener, Event $event){
		$listener->{$this->getMethod()}($event);
	}

	public function getMethod(){
		return $this->method;
	}
}