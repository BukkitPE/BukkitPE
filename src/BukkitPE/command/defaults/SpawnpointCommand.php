<?php
namespace BukkitPE\command\defaults;

use BukkitPE\command\Command;
use BukkitPE\command\CommandSender;
use BukkitPE\event\TranslationContainer;
use BukkitPE\level\Position;
use BukkitPE\Player;
use BukkitPE\utils\TextFormat;

class SpawnpointCommand extends VanillaCommand{

	public function __construct($name){
		parent::__construct(
			$name,
			"%BukkitPE.command.spawnpoint.description",
			"%commands.spawnpoint.usage"
		);
		$this->setPermission("BukkitPE.command.spawnpoint");
	}

	public function execute(CommandSender $sender, $currentAlias, array $args){
		if(!$this->testPermission($sender)){
			return true;
		}

		$target = null;

		if(count($args) === 0){
			if($sender instanceof Player){
				$target = $sender;
			}else{
				$sender->sendMessage(TextFormat::RED . "Please provide a player!");

				return true;
			}
		}else{
			$target = $sender->getServer()->getPlayer($args[0]);
			if($target === null){
				$sender->sendMessage(new TranslationContainer(TextFormat::RED . "%commands.generic.player.notFound"));

				return true;
			}
		}

		$level = $target->getLevel();

		if(count($args) === 4){
			if($level !== null){
				$pos = $sender instanceof Player ? $sender->getPosition() : $level->getSpawnLocation();
				$x = (int) $this->getRelativeDouble($pos->x, $sender, $args[1]);
				$y = $this->getRelativeDouble($pos->y, $sender, $args[2], 0, 128);
				$z = $this->getRelativeDouble($pos->z, $sender, $args[3]);
				$target->setSpawn(new Position($x, $y, $z, $level));

				Command::broadcastCommandMessage($sender, new TranslationContainer("commands.spawnpoint.success", [$target->getName(), round($x, 2), round($y, 2), round($z, 2)]));

				return true;
			}
		}elseif(count($args) <= 1){
			if($sender instanceof Player){
				$pos = new Position((int) $sender->x, (int) $sender->y, (int) $sender->z, $sender->getLevel());
				$target->setSpawn($pos);

				Command::broadcastCommandMessage($sender, new TranslationContainer("commands.spawnpoint.success", [$target->getName(), round($pos->x, 2), round($pos->y, 2), round($pos->z, 2)]));
				return true;
			}else{
				$sender->sendMessage(TextFormat::RED . "Please provide a player!");

				return true;
			}
		}

		$sender->sendMessage(new TranslationContainer("commands.generic.usage", [$this->usageMessage]));

		return true;
	}
}
