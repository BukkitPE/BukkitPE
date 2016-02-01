<?php
namespace BukkitPE\command\defaults;

use BukkitPE\command\CommandSender;
use BukkitPE\event\TranslationContainer;
use BukkitPE\Player;


class SeedCommand extends VanillaCommand{

	public function __construct($name){
		parent::__construct(
			$name,
			"%BukkitPE.command.seed.description",
			"%commands.seed.usage"
		);
		$this->setPermission("BukkitPE.command.seed");
	}

	public function execute(CommandSender $sender, $currentAlias, array $args){
		if(!$this->testPermission($sender)){
			return true;
		}

		if($sender instanceof Player){
			$seed = $sender->getLevel()->getSeed();
		}else{
			$seed = $sender->getServer()->getDefaultLevel()->getSeed();
		}
		$sender->sendMessage(new TranslationContainer("commands.seed.success", [$seed]));

		return true;
	}
}