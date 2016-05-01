<?php
namespace BukkitPE\command\defaults;

use BukkitPE\command\Command;
use BukkitPE\command\CommandSender;
use BukkitPE\event\TranslationContainer;
use BukkitPE\Player;
use BukkitPE\utils\TextFormat;

class DeopCommand extends VanillaCommand{

	public function __construct($name){
		parent::__construct(
			$name,
			"%BukkitPE.command.deop.description",
			"%commands.deop.usage"
		);
		$this->setPermission("BukkitPE.command.op.take");
	}

	public function execute(CommandSender $sender, $currentAlias, array $args){
		if(!$this->testPermission($sender)){
			return true;
		}

		if(count($args) === 0){
			$sender->sendMessage(new TranslationContainer("commands.generic.usage", [$this->usageMessage]));

			return false;
		}

		$name = array_shift($args);

		$player = $sender->getServer()->getOfflinePlayer($name);
		$player->setOp(false);
		if($player instanceof Player){
			$player->sendMessage(TextFormat::RED . "You no longer have administrator privileges!");
		}
		Command::broadcastCommandMessage($sender, new TranslationContainer("commands.deop.success", [$player->getName()]));

		return true;
	}
}
