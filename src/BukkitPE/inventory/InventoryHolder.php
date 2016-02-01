<?php
namespace BukkitPE\inventory;

interface InventoryHolder{

	/**
	 * Get the object related inventory
	 *
	 * @return Inventory
	 */
	public function getInventory();
}