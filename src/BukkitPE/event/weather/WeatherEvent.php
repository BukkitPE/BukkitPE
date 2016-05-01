<?php
namespace BukkitPE\event\weather;

use BukkitPE\event\Event;
use BukkitPE\level\Level;

abstract class WeatherEvent extends Event{
    private $level;

    public function __construct(Level $level){
        $this->level = $level;
    }

    public function getLevel(){
        return $this->level;
    }
}