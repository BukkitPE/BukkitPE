<?php
namespace BukkitPE\command\defaults;

use BukkitPE\command\Command;
use BukkitPE\command\CommandSender;
use BukkitPE\event\TranslationContainer;


class PardonCommand extends VanillaCommand{

	public function __construct($name){
		parent::__construct(
			$name,
			"%BukkitPE.command.unban.player.description",
			"%commands.unban.usage"
		);
		$this->setPermission("BukkitPE.command.unban.player");
	}

	public function execute(CommandSender $sender, $currentAlias, array $args){
		if(!$this->testPermission($sender)){
			return true;
		}

		if(count($args) !== 1){
			$sender->sendMessage(new TranslationContainer("commands.generic.usage", [$this->usageMessage]));

			return false;
		}

		$sender->getServer()->getNameBans()->remove($args[0]);

		Command::broadcastCommandMessage($sender, new TranslationContainer("commands.unban.success", [$args[0]]));

		return true;
	}
}
