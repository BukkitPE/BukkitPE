<?php
namespace BukkitPE\command\defaults;

use BukkitPE\command\CommandSender;
use BukkitPE\event\TranslationContainer;
use BukkitPE\utils\TextFormat;

class PluginsCommand extends VanillaCommand{

	public function __construct($name){
		parent::__construct(
			$name,
			"%BukkitPE.command.plugins.description",
			"%BukkitPE.command.plugins.usage",
			["pl"]
		);
		$this->setPermission("BukkitPE.command.plugins");
	}

	public function execute(CommandSender $sender, $currentAlias, array $args){
		if(!$this->testPermission($sender)){
			return true;
		}
		$this->sendPluginList($sender);
		return true;
	}

	private function sendPluginList(CommandSender $sender){
		$list = "";
		foreach(($plugins = $sender->getServer()->getPluginManager()->getPlugins()) as $plugin){
			if(strlen($list) > 0){
				$list .= TextFormat::WHITE . ", ";
			}
			$list .= $plugin->isEnabled() ? TextFormat::GOLD : TextFormat::RED;
			$list .= $plugin->getDescription()->getFullName();
		}

		$sender->sendMessage(new TranslationContainer("BukkitPE.command.plugins.success", [count($plugins), $list]));
	}
}
