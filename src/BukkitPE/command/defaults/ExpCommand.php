<?php
namespace BukkitPE\command\defaults;

use BukkitPE\command\Command;
use BukkitPE\command\CommandSender;
use BukkitPE\event\TranslationContainer;
use BukkitPE\Player;
use BukkitPE\utils\TextFormat;

class ExpCommand extends VanillaCommand{

	public function __construct($name){
		parent::__construct($name, "%BukkitPE.command.xp.description","%commands.xp.usage", []);
		$this->setPermission("BukkitPE.command.xp");
	}

	public function execute(CommandSender $sender, $currentAlias, array $args){
		if(!$this->testPermission($sender)){
			return true;
		}
		$cmd = '';
		$player = null;
		$amount = '-1';
		
		if(isset($args[0])){
			$cmd = $args[0];
		}
		
		if(isset($args[1])){
			$player = $sender->getServer()->getPlayer($args[1]);
		}
		
		if(isset($args[2])){
			$amount = $args[2];
		}
		
		switch($cmd){
			case "add":
				if($player instanceof Player){
					if($amount <= 0){
						break;
					}else{
						$player->addExperience($amount);
						Command::broadcastCommandMessage($sender, new TranslationContainer("commands.xp.given", [$amount, $player->getName()]));
					}
					return;
				}
				$sender->sendMessage(new TranslationContainer(TextFormat::RED . "%commands.generic.player.notFound"));
				return;
			case "set":
				if($player instanceof Player){
					if($amount < 0){
						break;
					}else{
						$player->setExperience($amount);
						Command::broadcastCommandMessage($sender, new TranslationContainer("commands.xp.set", [$amount, $player->getName()]));
					}
					return;
				}
				$sender->sendMessage(new TranslationContainer(TextFormat::RED . "%commands.generic.player.notFound"));
				return;
		}
		$sender->sendMessage(TextFormat::RED . "Usage: " . $this->usageMessage);
		return;
	}
}