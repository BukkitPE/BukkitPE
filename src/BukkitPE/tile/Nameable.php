<?php
namespace BukkitPE\tile;


interface Nameable{


	/**
	 * @return string
	 */
	public function getName();

	/**
	 * @param void $str
	 */
	public function setName($str);

	/**
	 * @return bool
	 */
	public function hasName();
}
