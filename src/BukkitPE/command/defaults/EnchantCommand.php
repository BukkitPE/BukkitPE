<?php
namespace BukkitPE\command\defaults;


use BukkitPE\command\CommandSender;
use BukkitPE\event\TranslationContainer;
use BukkitPE\item\enchantment\Enchantment;
use BukkitPE\utils\TextFormat;

class EnchantCommand extends VanillaCommand{

	public function __construct($name){
		parent::__construct(
			$name,
			"%BukkitPE.command.enchant.description",
			"%commands.enchant.usage"
		);
		$this->setPermission("BukkitPE.command.enchant");
	}

	public function execute(CommandSender $sender, $currentAlias, array $args){
		if(!$this->testPermission($sender)){
			return true;
		}

		if(count($args) < 2){
			$sender->sendMessage(new TranslationContainer("commands.generic.usage", [$this->usageMessage]));

			return true;
		}

		$player = $sender->getServer()->getPlayer($args[0]);

		if($player === null){
			$sender->sendMessage(new TranslationContainer(TextFormat::RED . "%commands.generic.player.notFound"));
			return true;
		}

		$enchantId = (int) $args[1];
		$enchantLevel = isset($args[2]) ? (int) $args[2] : 1;

		$enchantment = Enchantment::getEnchantment($enchantId);
		if($enchantment->getId() === Enchantment::TYPE_INVALID){
			$sender->sendMessage(new TranslationContainer("commands.enchant.notFound", [$enchantId]));
			return true;
		}

		$enchantment->setLevel($enchantLevel);

		$item = $player->getInventory()->getItemInHand();

		if($item->getId() <= 0){
			$sender->sendMessage(new TranslationContainer("commands.enchant.noItem"));
			return true;
		}

		$item->addEnchantment($enchantment);
		$player->getInventory()->setItemInHand($item);


		self::broadcastCommandMessage($sender, new TranslationContainer("%commands.enchant.success"));
		return true;
	}
}