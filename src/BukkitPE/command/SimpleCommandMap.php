<?php
namespace BukkitPE\command;

use BukkitPE\command\defaults\BanCommand;
use BukkitPE\command\defaults\BanIpCommand;
use BukkitPE\command\defaults\BanListCommand;
use BukkitPE\command\defaults\DefaultGamemodeCommand;
use BukkitPE\command\defaults\DeopCommand;
use BukkitPE\command\defaults\DifficultyCommand;
use BukkitPE\command\defaults\DumpMemoryCommand;
use BukkitPE\command\defaults\EffectCommand;
use BukkitPE\command\defaults\EnchantCommand;
use BukkitPE\command\defaults\ExpCommand;
use BukkitPE\command\defaults\GamemodeCommand;
use BukkitPE\command\defaults\GarbageCollectorCommand;
use BukkitPE\command\defaults\GiveCommand;
use BukkitPE\command\defaults\HelpCommand;
use BukkitPE\command\defaults\KickCommand;
use BukkitPE\command\defaults\KillCommand;
use BukkitPE\command\defaults\ListCommand;
use BukkitPE\command\defaults\MeCommand;
use BukkitPE\command\defaults\OpCommand;
use BukkitPE\command\defaults\PardonCommand;
use BukkitPE\command\defaults\PardonIpCommand;
use BukkitPE\command\defaults\ParticleCommand;
use BukkitPE\command\defaults\PluginsCommand;
use BukkitPE\command\defaults\ReloadCommand;
use BukkitPE\command\defaults\SaveCommand;
use BukkitPE\command\defaults\SaveOffCommand;
use BukkitPE\command\defaults\SaveOnCommand;
use BukkitPE\command\defaults\SayCommand;
use BukkitPE\command\defaults\SeedCommand;
use BukkitPE\command\defaults\SetWorldSpawnCommand;
use BukkitPE\command\defaults\SpawnpointCommand;
use BukkitPE\command\defaults\StatusCommand;
use BukkitPE\command\defaults\StopCommand;
use BukkitPE\command\defaults\TeleportCommand;
use BukkitPE\command\defaults\TellCommand;
use BukkitPE\command\defaults\TimeCommand;
use BukkitPE\command\defaults\TimingsCommand;
use BukkitPE\command\defaults\VanillaCommand;
use BukkitPE\command\defaults\VersionCommand;
use BukkitPE\command\defaults\WeatherCommand;
use BukkitPE\command\defaults\WhitelistCommand;
use BukkitPE\event\TranslationContainer;
use BukkitPE\Server;
use BukkitPE\utils\MainLogger;
use BukkitPE\utils\TextFormat;

class SimpleCommandMap implements CommandMap{

	/**
	 * @var Command[]
	 */
	protected $knownCommands = [];

	/** @var Server */
	private $server;

	public function __construct(Server $server){
		$this->server = $server;
		$this->setDefaultCommands();
	}

	private function setDefaultCommands(){
		$this->register("BukkitPE", new VersionCommand("version"));
		$this->register("BukkitPE", new PluginsCommand("plugins"));
		$this->register("BukkitPE", new SeedCommand("seed"));
		$this->register("BukkitPE", new HelpCommand("help"));
		$this->register("BukkitPE", new StopCommand("stop"));
		$this->register("BukkitPE", new TellCommand("tell"));
		$this->register("BukkitPE", new DefaultGamemodeCommand("defaultgamemode"));
		$this->register("BukkitPE", new BanCommand("ban"));
		$this->register("BukkitPE", new BanIpCommand("ban-ip"));
		$this->register("BukkitPE", new BanListCommand("banlist"));
		$this->register("BukkitPE", new PardonCommand("pardon"));
		$this->register("BukkitPE", new PardonIpCommand("pardon-ip"));
		$this->register("BukkitPE", new SayCommand("say"));
		$this->register("BukkitPE", new MeCommand("me"));
		$this->register("BukkitPE", new ListCommand("list"));
		$this->register("BukkitPE", new DifficultyCommand("difficulty"));
		$this->register("BukkitPE", new KickCommand("kick"));
		$this->register("BukkitPE", new OpCommand("op"));
		$this->register("BukkitPE", new DeopCommand("deop"));
		$this->register("BukkitPE", new WhitelistCommand("whitelist"));
		$this->register("BukkitPE", new SaveOnCommand("save-on"));
		$this->register("BukkitPE", new SaveOffCommand("save-off"));
		$this->register("BukkitPE", new SaveCommand("save-all"));
		$this->register("BukkitPE", new GiveCommand("give"));
		$this->register("BukkitPE", new EffectCommand("effect"));
		$this->register("BukkitPE", new EnchantCommand("enchant"));
		$this->register("BukkitPE", new ExpCommand("xp"));
		$this->register("BukkitPE", new ParticleCommand("particle"));
		$this->register("BukkitPE", new GamemodeCommand("gamemode"));
		$this->register("BukkitPE", new KillCommand("kill"));
		$this->register("BukkitPE", new SpawnpointCommand("spawnpoint"));
		$this->register("BukkitPE", new SetWorldSpawnCommand("setworldspawn"));
		$this->register("BukkitPE", new TeleportCommand("tp"));
		$this->register("BukkitPE", new TimeCommand("time"));
		$this->register("BukkitPE", new TimingsCommand("timings"));
		$this->register("BukkitPE", new ReloadCommand("reload"));
		$this->register("BukkitPE", new WeatherCommand("weather"));

		if($this->server->getProperty("debug.commands", false)){
			$this->register("BukkitPE", new StatusCommand("status"));
			$this->register("BukkitPE", new GarbageCollectorCommand("gc"));
			$this->register("BukkitPE", new DumpMemoryCommand("dumpmemory"));
		}
	}


	public function registerAll($fallbackPrefix, array $commands){
		foreach($commands as $command){
			$this->register($fallbackPrefix, $command);
		}
	}

	public function register($fallbackPrefix, Command $command, $label = null){
		if($label === null){
			$label = $command->getName();
		}
		$label = strtolower(trim($label));
		$fallbackPrefix = strtolower(trim($fallbackPrefix));

		$registered = $this->registerAlias($command, false, $fallbackPrefix, $label);

		$aliases = $command->getAliases();
		foreach($aliases as $index => $alias){
			if(!$this->registerAlias($command, true, $fallbackPrefix, $alias)){
				unset($aliases[$index]);
			}
		}
		$command->setAliases($aliases);

		if(!$registered){
			$command->setLabel($fallbackPrefix . ":" . $label);
		}

		$command->register($this);

		return $registered;
	}

	private function registerAlias(Command $command, $isAlias, $fallbackPrefix, $label){
		$this->knownCommands[$fallbackPrefix . ":" . $label] = $command;
		if(($command instanceof VanillaCommand or $isAlias) and isset($this->knownCommands[$label])){
			return false;
		}

		if(isset($this->knownCommands[$label]) and $this->knownCommands[$label]->getLabel() !== null and $this->knownCommands[$label]->getLabel() === $label){
			return false;
		}

		if(!$isAlias){
			$command->setLabel($label);
		}

		$this->knownCommands[$label] = $command;

		return true;
	}

	public function dispatch(CommandSender $sender, $commandLine){
		$args = explode(" ", $commandLine);

		if(count($args) === 0){
			return false;
		}

		$sentCommandLabel = strtolower(array_shift($args));
		$target = $this->getCommand($sentCommandLabel);

		if($target === null){
			return false;
		}

		$target->timings->startTiming();
		try{
			$target->execute($sender, $sentCommandLabel, $args);
		}catch(\Exception $e){
			$sender->sendMessage(new TranslationContainer(TextFormat::RED . "%commands.generic.exception"));
			$this->server->getLogger()->critical($this->server->getLanguage()->translateString("BukkitPE.command.exception", [$commandLine, (string) $target, $e->getMessage()]));
			$logger = $sender->getServer()->getLogger();
			if($logger instanceof MainLogger){
				$logger->logException($e);
			}
		}
		$target->timings->stopTiming();

		return true;
	}

	public function clearCommands(){
		foreach($this->knownCommands as $command){
			$command->unregister($this);
		}
		$this->knownCommands = [];
		$this->setDefaultCommands();
	}

	public function getCommand($name){
		if(isset($this->knownCommands[$name])){
			return $this->knownCommands[$name];
		}

		return null;
	}

	/**
	 * @return Command[]
	 */
	public function getCommands(){
		return $this->knownCommands;
	}


	/**
	 * @return void
	 */
	public function registerServerAliases(){
		$values = $this->server->getCommandAliases();

		foreach($values as $alias => $commandStrings){
			if(strpos($alias, ":") !== false or strpos($alias, " ") !== false){
				$this->server->getLogger()->warning($this->server->getLanguage()->translateString("BukkitPE.command.alias.illegal", [$alias]));
				continue;
			}

			$targets = [];

			$bad = "";
			foreach($commandStrings as $commandString){
				$args = explode(" ", $commandString);
				$command = $this->getCommand($args[0]);

				if($command === null){
					if(strlen($bad) > 0){
						$bad .= ", ";
					}
					$bad .= $commandString;
				}else{
					$targets[] = $commandString;
				}
			}

			if(strlen($bad) > 0){
				$this->server->getLogger()->warning($this->server->getLanguage()->translateString("BukkitPE.command.alias.notFound", [$alias, $bad]));
				continue;
			}

			//These registered commands have absolute priority
			if(count($targets) > 0){
				$this->knownCommands[strtolower($alias)] = new FormattedCommandAlias(strtolower($alias), $targets);
			}else{
				unset($this->knownCommands[strtolower($alias)]);
			}

		}
	}


}
