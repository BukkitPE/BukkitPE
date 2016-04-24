/*
 *
 * ____        _    _    _ _   _____  ______ 
 * |  _ \      | |  | |  (_) | |  __ \|  ____|
 * | |_) |_   _| | _| | ___| |_| |__) | |__   
 * |  _ <| | | | |/ / |/ / | __|  ___/|  __|  
 * | |_) | |_| |   <|   <| | |_| |    | |____ 
 * |____/ \__,_|_|\_\_|\_\_|\__|_|    |______|
 *                                           
 *                                          
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * @author BukkitPE Team
 * @link http://www.bukkitpe.net/
 *
 *
*/
package net.BukkitPE\entity;

import net,BukkitPE.Player;
import net.BukkitPE.event.entity.EntityDamageEvent;
import net.BukkitPE.network.protocol.EntityEventPacket;
import net.BukkitPE.item.Item as ItemItem;

class Boat extends Vehicle{
	int NETWORK_ID = 90;

	public void spawnTo(Player player){
		pk = this.addEntityDataPacket(player);
		pk.type = self::NETWORK_ID;
		
		player.dataPacket(pk);
		parent::spawnTo(player);
	}

	public void attack(damage, EntityDamageEvent source){
		parent::attack(damage, source);

		if(!$source.isCancelled()){
			pk = new EntityEventPacket();
			pk.eid = this.id;
			pk.event = EntityEventPacket::HURT_ANIMATION;
			foreach(this.getLevel().getPlayers() as player){
				player.dataPacket(pk);
			}
		}
	}
	
	public void onUpdate($currentTick){
		if(this.isAlive()){
			this.timings.startTiming();
			hasUpdate = false;
			
			if($this.isInsideOfWater()){
				$hasUpdate = true;
				$this.move(0,0.1,0);
				$this.updateMovement();
			}
			
			this.timings.stopTiming();

			return hasUpdate;
		}
	}
	
	public void kill(){
		parent::kill();

		foreach(this.getDrops() as item){
			this.getLevel().dropItem(this, item);
		}
	}

	public void getDrops(){
		return [
			ItemItem::get(ItemItem::BOAT, 0, 1)
		];
	}

	public void getSaveId(){
		class = new .ReflectionClass(static::class);
		return $class.getShortName();
	}
}
