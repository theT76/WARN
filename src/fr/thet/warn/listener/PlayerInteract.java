package fr.thet.warn.listener;

import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import fr.thet.warn.Main;
import fr.thet.warn.data.PlayerData;
import fr.thet.warn.sanction.Ban;
import fr.thet.warn.sanction.Warning;

public class PlayerInteract implements Listener {

	private Main plugin;
	
	public PlayerInteract(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e){
		if(e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK )){
			final Player p = e.getPlayer();
			
			if(!PlayerData.cps.contains(p)){
				PlayerData.cps.add(p);
				PlayerData.clicks.put(p, 1);
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){

					@Override
					public void run() {
						if(!PlayerData.cps.contains(p)){
							return;
						}
						int c = PlayerData.clicks.get(p);
						if(c >= 90){
							Warning.WarningCps(p, c);
						}
						if(c >= 110){
							Ban.BanPlayer("AutoClick (" + (c/5) + "CPS)", p, "WARN", plugin);
						}
						PlayerData.cps.remove(p);
					}}, 100);
			}else{
				int c = PlayerData.clicks.get(p);
				c++;
				PlayerData.clicks.remove(p);
				PlayerData.clicks.put(p, c);
			}
			
			if(p.getItemInHand() != null){
				if(p.getItemInHand() == null) return;
				if(!p.getItemInHand().hasItemMeta()) return;
				if(p.getItemInHand().getItemMeta().hasEnchant(Enchantment.DAMAGE_ALL)){
					if(p.getItemInHand().getEnchantmentLevel(Enchantment.DAMAGE_ALL) > 20){
						Ban.BanPlayer("CheatEnchant", p, "WARN", plugin);
					}
				}
			}
		}
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK )){
			final Player p = e.getPlayer();
			
			//TODO CPS
			if(!PlayerData.rcps.contains(p)){
				PlayerData.rcps.add(p);
				PlayerData.rclicks.put(p, 1);
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){

					@Override
					public void run() {
						if(!PlayerData.rcps.contains(p)){
							return;
						}
						int c = PlayerData.rclicks.get(p);
						if(c >= 90){
							Warning.WarningCps(p, c);
						}
						if(c >= 110){
							Ban.BanPlayer("AutoClick (" + (c/5) + "CPS)", p, "WARN", plugin);
						}
						PlayerData.rcps.remove(p);
					}}, 100);
			}else{
				int c = PlayerData.rclicks.get(p);
				c++;
				PlayerData.rclicks.remove(p);
				PlayerData.rclicks.put(p, c);
			}
			
			if(p.getItemInHand() != null){
				if(p.getItemInHand() == null) return;
				if(!p.getItemInHand().hasItemMeta()) return;
				if(p.getItemInHand().getItemMeta().hasEnchant(Enchantment.DAMAGE_ALL)){
					if(p.getItemInHand().getEnchantmentLevel(Enchantment.DAMAGE_ALL) > 20){
						Ban.BanPlayer("CheatEnchant", p, "WARN", plugin);
					}
				}
			}
		}
	}
	
}
