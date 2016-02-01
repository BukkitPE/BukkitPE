<?php
namespace BukkitPE\command\defaults;

use BukkitPE\command\Command;
use BukkitPE\command\CommandSender;
use BukkitPE\event\TranslationContainer;


class SaveOffCommand extends VanillaCommand{

	public function __construct($name){
		parent::__construct(
			$name,
			"%BukkitPE.command.saveoff.description",
			"%commands.save-off.usage"
		);
		$this->setPermission("BukkitPE.command.save.disable");
	}

	public function execute(CommandSender $sender, $currentAlias, array $args){
		if(!$this->testPermission($sender)){
			return true;
		}

		$sender->getServer()->setAutoSave(false);

		Command::broadcastCommandMessage($sender, new TranslationContainer("commands.save.disabled"));

		return true;
	}
}