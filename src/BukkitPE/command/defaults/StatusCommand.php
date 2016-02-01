<?php
namespace BukkitPE\command\defaults;

use BukkitPE\command\CommandSender;
use BukkitPE\utils\TextFormat;
use BukkitPE\utils\Utils;

class StatusCommand extends VanillaCommand{

	public function __construct($name){
		parent::__construct(
			$name,
			"%BukkitPE.command.status.description",
			"%BukkitPE.command.status.usage"
		);
		$this->setPermission("BukkitPE.command.status");
	}

	public function execute(CommandSender $sender, $currentAlias, array $args){
		if(!$this->testPermission($sender)){
			return true;
		}

		$rUsage = Utils::getRealMemoryUsage();
		$mUsage = Utils::getMemoryUsage(true);

		$server = $sender->getServer();
		$sender->sendMessage(TextFormat::GREEN . "---- " . TextFormat::WHITE . "%BukkitPE.command.status.title" . TextFormat::GREEN . " ----");
		$sender->sendMessage(TextFormat::GOLD . "%BukkitPE.command.status.player" . TextFormat::GREEN . \count($sender->getServer()->getOnlinePlayers()) . "/" . $sender->getServer()->getMaxPlayers());

		$time = microtime(true) - \BukkitPE\START_TIME;

		$seconds = floor($time % 60);
		$minutes = null;
		$hours = null;
		$days = null;

		if($time >= 60){
			$minutes = floor(($time % 3600) / 60);
			if($time >= 3600){
				$hours = floor(($time % (3600 * 24)) / 3600);
				if($time >= 3600 * 24){
					$days = floor($time / (3600 * 24));
				}
			}
		}

		$uptime = ($minutes !== null ?
				($hours !== null ?
					($days !== null ?
						"$days %BukkitPE.command.status.days "
						: "") . "$hours %BukkitPE.command.status.hours "
					: "") . "$minutes %BukkitPE.command.status.minutes "
				: "") . "$seconds %BukkitPE.command.status.seconds";

		$sender->sendMessage(TextFormat::GOLD . "%BukkitPE.command.status.uptime " . TextFormat::RED . $uptime);

		$tpsColor = TextFormat::GREEN;
		if($server->getTicksPerSecondAverage() < 10){
			$tpsColor = TextFormat::GOLD;
		}elseif($server->getTicksPerSecondAverage() < 1){
			$tpsColor = TextFormat::RED;
		}

		$tpsColour = TextFormat::GREEN;
		if($server->getTicksPerSecond() < 10){
			$tpsColour = TextFormat::GOLD;
		}elseif($server->getTicksPerSecond() < 1){
			$tpsColour = TextFormat::RED;
		}
		$sender->sendMessage(TextFormat::GOLD . "%BukkitPE.command.status.AverageTPS " . $tpsColor . $server->getTicksPerSecondAverage() . " (" . $server->getTickUsageAverage() . "%)");
		$sender->sendMessage(TextFormat::GOLD . "%BukkitPE.command.status.CurrentTPS " . $tpsColour . $server->getTicksPerSecond() . " (" . $server->getTickUsage() . "%)");

		$sender->sendMessage(TextFormat::GOLD . "%BukkitPE.command.status.Networkupload " . TextFormat::RED . \round($server->getNetwork()->getUpload() / 1024, 2) . " kB/s");
		$sender->sendMessage(TextFormat::GOLD . "%BukkitPE.command.status.Networkdownload " . TextFormat::RED . \round($server->getNetwork()->getDownload() / 1024, 2) . " kB/s");

		$sender->sendMessage(TextFormat::GOLD . "%BukkitPE.command.status.Threadcount " . TextFormat::RED . Utils::getThreadCount());

		$sender->sendMessage(TextFormat::GOLD . "%BukkitPE.command.status.Mainmemory " . TextFormat::RED . number_format(round(($mUsage[0] / 1024) / 1024, 2)) . " MB.");
		$sender->sendMessage(TextFormat::GOLD . "%BukkitPE.command.status.Totalmemory " . TextFormat::RED . number_format(round(($mUsage[1] / 1024) / 1024, 2)) . " MB.");
		$sender->sendMessage(TextFormat::GOLD . "%BukkitPE.command.status.Totalvirtualmemory " . TextFormat::RED . number_format(round(($mUsage[2] / 1024) / 1024, 2)) . " MB.");
		$sender->sendMessage(TextFormat::GOLD . "%BukkitPE.command.status.Heapmemory " . TextFormat::RED . number_format(round(($rUsage[0] / 1024) / 1024, 2)) . " MB.");
		$sender->sendMessage(TextFormat::GOLD . "%BukkitPE.command.status.Maxmemorysystem " . TextFormat::RED . number_format(round(($mUsage[2] / 1024) / 1024, 2)) . " MB.");

		if($server->getProperty("memory.global-limit") > 0){
			$sender->sendMessage(TextFormat::GOLD . "%BukkitPE.command.status.Maxmemorymanager " . TextFormat::RED . number_format(round($server->getProperty("memory.global-limit"), 2)) . " MB.");
		}

		foreach($server->getLevels() as $level){
			$sender->sendMessage(TextFormat::GOLD . "%BukkitPE.command.status.World \"" . $level->getFolderName() . "\"" . ($level->getFolderName() !== $level->getName() ? " (" . $level->getName() . ")" : "") . ": " .
				TextFormat::RED . number_format(count($level->getChunks())) . TextFormat::GREEN . " %BukkitPE.command.status.chunks " .
				TextFormat::RED . number_format(count($level->getEntities())) . TextFormat::GREEN . " %BukkitPE.command.status.entities " .
				TextFormat::RED . number_format(count($level->getTiles())) . TextFormat::GREEN . " %BukkitPE.command.status.tiles " .
				"%BukkitPE.command.status.Time " . (($level->getTickRate() > 1 or $level->getTickRateTime() > 40) ? TextFormat::RED : TextFormat::YELLOW) . round($level->getTickRateTime(), 2) . "%BukkitPE.command.status.ms" . ($level->getTickRate() > 1 ? " (tick rate " . $level->getTickRate() . ")" : "")
			);
		}

		return true;
	}
}
