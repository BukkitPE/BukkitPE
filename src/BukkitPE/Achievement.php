<?php
namespace BukkitPE;

use BukkitPE\event\TranslationContainer;
use BukkitPE\utils\TextFormat;

/**
 * Handles the achievement list and a bit more
 */
abstract class Achievement{
	/**
	 * @var array[]
	 */
	public static $list = [
		/*"openInventory" => array(
			"name" => "Taking Inventory",
			"requires" => [],
		),*/
		"mineWood" => [
			"name" => "§l[Getting Wood]",
			"requires" => [ //"openInventory",
			],
		],
		"buildWorkBench" => [
			"name" => "§l[Benchmarking]",
			"requires" => [
				"mineWood",
			],
		],
		"buildPickaxe" => [
			"name" => "§l[Time to Mine!]",
			"requires" => [
				"buildWorkBench",
			],
		],
		"buildFurnace" => [
			"name" => "§l[Hot Topic]",
			"requires" => [
				"buildPickaxe",
			],
		],
		"acquireIron" => [
			"name" => "§l[Acquire hardware]",
			"requires" => [
				"buildFurnace",
			],
		],
		"buildHoe" => [
			"name" => "§l[Time to Farm!]",
			"requires" => [
				"buildWorkBench",
			],
		],
		"makeBread" => [
			"name" => "§l[Bake Bread]",
			"requires" => [
				"buildHoe",
			],
		],
		"bakeCake" => [
			"name" => "§l[The Lie]",
			"requires" => [
				"buildHoe",
			],
		],
		"buildBetterPickaxe" => [
			"name" => "§l[Getting an Upgrade]",
			"requires" => [
				"buildPickaxe",
			],
		],
		"buildSword" => [
"name" => "§l[Time to Strike!]",
			"requires" => [
				"buildWorkBench",
			],
		],
		"diamonds" => [
			"name" => "§l[DIAMONDS!]",
			"requires" => [
				"acquireIron",
			],
		],

	];


	public static function broadcast(Player $player, $achievementId){
		if(isset(Achievement::$list[$achievementId])){
			$translation = new TranslationContainer("chat.type.achievement", [$player->getDisplayName(), TextFormat::RED . Achievement::$list[$achievementId]["name"]]);
			if(Server::getInstance()->getConfigString("announce-player-achievements", true) === true){
				Server::getInstance()->broadcastMessage($translation);
			}else{
				$player->sendMessage($translation);
			}

			return true;
		}

		return false;
	}

	public static function add($achievementId, $achievementName, array $requires = []){
		if(!isset(Achievement::$list[$achievementId])){
			Achievement::$list[$achievementId] = [
				"name" => $achievementName,
				"requires" => $requires,
			];

			return true;
		}

		return false;
	}


}
