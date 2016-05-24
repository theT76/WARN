package fr.thet.warn.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import fr.thet.warn.data.PlayerData;

public class EntityDamage implements Listener {

	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		long mili = System.currentTimeMillis();
		if(!(e.getEntity() instanceof Player)) return;
		if((mili - PlayerData.lastban) < 1500){
			if(e.getCause().equals(DamageCause.FIRE) ||(e.getCause().equals(DamageCause.FIRE_TICK))){
				e.setCancelled(true);
			}
		}
	}
	
}
