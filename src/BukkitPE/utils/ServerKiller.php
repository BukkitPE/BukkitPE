<?php

namespace BukkitPE\utils;

use BukkitPE\Thread;

class ServerKiller extends Thread{

	public $time;

	public function __construct($time = 15){
		$this->time = $time;
	}

	public function run(){
		sleep($this->time);
		echo "\nTook too long to stop, server was killed forcefully!\n";
		@\BukkitPE\kill(getmypid());
	}

	public function getThreadName(){
		return "Server Killer";
	}
}
