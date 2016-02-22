<?php
namespace BukkitPE\command\defaults;

use BukkitPE\command\Command;
use BukkitPE\command\CommandSender;
use BukkitPE\event\TranslationContainer;


class StopCommand extends VanillaCommand{

	public function __construct($name){
		parent::__construct(
			$name,
			"%BukkitPE.command.stop.description",
			"%commands.stop.usage"
		);
		$this->setPermission("BukkitPE.command.stop");
	}

	public function execute(CommandSender $sender, $currentAlias, array $args){
		if(!$this->testPermission($sender)){
			return true;
		}

		Command::broadcastCommandMessage($sender, new TranslationContainer(TextFormat::RED . "commands.stop.start"));
		$sender->getServer()->setshutdownreason(implode(" ", $args));
		$sender->getServer()->shutdown();

		return true;
	}
}
