<?php
namespace BukkitPE\command\defaults;
use BukkitPE\command\CommandSender;
use BukkitPE\plugin\Plugin;
use BukkitPE\Server;
use BukkitPE\utils\TextFormat;
use BukkitPE\network\protocol\Info;
class MakeServerCommand extends VanillaCommand{
	public function __construct($name){
		parent::__construct(
			$name,
			"Creates a BukkitPE Phar",
			"/makeserver"
		);
		$this->setPermission("BukkitPE.command.makeserver");
	}
	public function execute(CommandSender $sender, $commandLabel, array $args){
		if(!$this->testPermission($sender)){
			return false;
		}
		$server = $sender->getServer();
		$pharPath = Server::getInstance()->getPluginPath() . DIRECTORY_SEPARATOR . "BukkitPE" . DIRECTORY_SEPARATOR . $server->getName() . "_" . $server->getBukkitPEVersion() . ".phar";
		if(file_exists($pharPath)){
			$sender->sendMessage("Phar file already exists, overwriting...");
			@unlink($pharPath);
		}
		$phar = new \Phar($pharPath);
		$phar->setMetadata([
			"name" => $server->getName(),
			"version" => $server->getBukkitPEVersion(),
			"api" => $server->getApiVersion(),
			"minecraft" => $server->getVersion(),
			"protocol" => Info::CURRENT_PROTOCOL,
			"creator" => "BukkitPE MakeServerCommand",
			"creationDate" => time()
		]);
		$phar->setStub('<?php define("BukkitPE\\\\PATH", "phar://". __FILE__ ."/"); require_once("phar://". __FILE__ ."/src/BukkitPE/BukkitPE.php");  __HALT_COMPILER();');
		$phar->setSignatureAlgorithm(\Phar::SHA1);
		$phar->startBuffering();
		$filePath = substr(\BukkitPE\PATH, 0, 7) === "phar://" ? \BukkitPE\PATH : realpath(\BukkitPE\PATH) . "/";
		$filePath = rtrim(str_replace("\\", "/", $filePath), "/") . "/";
		foreach(new \RecursiveIteratorIterator(new \RecursiveDirectoryIterator($filePath . "src")) as $file){
			$path = ltrim(str_replace(["\\", $filePath], ["/", ""], $file), "/");
			if($path{0} === "." or strpos($path, "/.") !== false or substr($path, 0, 4) !== "src/"){
				continue;
			}
			$phar->addFile($file, $path);
			$sender->sendMessage("[BukkitPE] Adding $path");
		}
		foreach($phar as $file => $finfo){
			/** @var \PharFileInfo $finfo */
			if($finfo->getSize() > (1024 * 512)){
				$finfo->compress(\Phar::GZ);
			}
		}
		if(!isset($args[0]) or (isset($args[0]) and $args[0] != "nogz")){
			$phar->compressFiles(\Phar::GZ);
		}
		$phar->stopBuffering();
		$sender->sendMessage($server->getName() . " " . $server->getBukkitPEVersion() . " Phar file has been created on " . $pharPath);
		return true;
	}
}