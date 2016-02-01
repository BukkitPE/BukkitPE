<?php
namespace BukkitPE\command;

use BukkitPE\permission\Permissible;

interface CommandSender extends Permissible{

	/**
	 * @param string $message
	 */
	public function sendMessage($message);

	/**
	 * @return \BukkitPE\Server
	 */
	public function getServer();

	/**
	 * @return string
	 */
	public function getName();


}