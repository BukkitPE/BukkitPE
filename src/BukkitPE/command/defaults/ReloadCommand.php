<?php
namespace BukkitPE\command\defaults;

use BukkitPE\command\Command;
use BukkitPE\command\CommandSender;
use BukkitPE\event\TranslationContainer;
use BukkitPE\utils\TextFormat;

class ReloadCommand extends VanillaCommand{

	public function __construct($name){
		parent::__construct(
			$name,
			"%BukkitPE.command.reload.description",
			"%BukkitPE.command.reload.usage"
		);
		$this->setPermission("BukkitPE.command.reload");
	}

	public function execute(CommandSender $sender, $currentAlias, array $args){
		if(!$this->testPermission($sender)){
			return true;
		}

		Command::broadcastCommandMessage($sender, new TranslationContainer(TextFormat::YELLOW . "%BukkitPE.command.reload.reloading"));

		$sender->getServer()->reload();
		Command::broadcastCommandMessage($sender, new TranslationContainer(TextFormat::YELLOW . "%BukkitPE.command.reload.reloaded"));

		return true;
	}
}
