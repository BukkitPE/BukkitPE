<?php
namespace BukkitPE\command\defaults;

use BukkitPE\command\CommandSender;
use BukkitPE\event\TranslationContainer;
use BukkitPE\Player;
use BukkitPE\utils\TextFormat;

class TellCommand extends VanillaCommand{

	public function __construct($name){
		parent::__construct(
			$name,
			"%BukkitPE.command.tell.description",
			"%commands.message.usage",
			["w", "msg"]
		);
		$this->setPermission("BukkitPE.command.tell");
	}

	public function execute(CommandSender $sender, $currentAlias, array $args){
		if(!$this->testPermission($sender)){
			return true;
		}

		if(count($args) < 2){
			$sender->sendMessage(new TranslationContainer("commands.generic.usage", [$this->usageMessage]));

			return false;
		}

		$name = strtolower(array_shift($args));

		$player = $sender->getServer()->getPlayer($name);

		if($player === $sender){
			$sender->sendMessage(new TranslationContainer(TextFormat::RED . "%commands.message.sameTarget"));
			return true;
		}

		if($player instanceof Player){
			$sender->sendMessage("§d[§6".$sender->getName()." §5->§6 " . $player->getDisplayName() . "§d]§b " . implode(" ", $args));
			$player->sendMessage("§d[§6" . ($sender instanceof Player ? $sender->getDisplayName() : $sender->getName()) . " §5->§6 ".$player->getName()."§d] §b" . implode(" ", $args));
		}else{
			$sender->sendMessage(new TranslationContainer("commands.generic.player.notFound"));
		}

		return true;
	}
}
