<?php
namespace BukkitPE\inventory;

use BukkitPE\utils\UUID;

interface Recipe{

	/**
	 * @return \BukkitPE\item\Item
	 */
	public function getResult();

	public function registerToCraftingManager();

	/**
	 * @return UUID
	 */
	public function getId();
}