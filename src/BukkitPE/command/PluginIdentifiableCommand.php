<?php
namespace BukkitPE\command;

interface PluginIdentifiableCommand{

	/**
	 * @return \BukkitPE\plugin\Plugin
	 */
	public function getPlugin();
}
