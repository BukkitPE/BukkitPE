<?php
namespace BukkitPE\event\weather;

use BukkitPE\event\Cancellable;
use BukkitPE\level\Level;

class WeatherChangeEvent extends WeatherEvent implements Cancellable{
    public static $handlerList = null;
    private $to;

    public function __construct(Level $level, $to = false){
        parent::__construct($level);
        $this->to = $to;
    }

    public function getWeatherState(){
        return $this->to;
    }
}