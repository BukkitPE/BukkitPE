<?php
namespace BukkitPE\inventory;

interface TransactionGroup{

	/**
	 * @return float
	 */
	function getCreationTime();

	/**
	 * @return Transaction[]
	 */
	function getTransactions();

	/**
	 * @return Inventory[]
	 */
	function getInventories();

	/**
	 * @param Transaction $transaction
	 */
	function addTransaction(Transaction $transaction);

	/**
	 * @return bool
	 */
	function canExecute();

	/**
	 * @return bool
	 */
	function execute();

	/**
	 * @return bool
	 */
	function hasExecuted();

}