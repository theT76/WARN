package fr.thet.warn.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.potion.PotionEffectType;

import fr.thet.warn.Main;
import fr.thet.warn.data.PlayerData;
import fr.thet.warn.sanction.Ban;

public class PlayerVelocity implements Listener {

	private Main plugin;
	
	public PlayerVelocity(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
	public void onVelocityChange(PlayerVelocityEvent e){
		final Player p = e.getPlayer();
		if(p.getVehicle() != null) return;
		if(PlayerData.joined.contains(p)) return;
		final Location hitloc = p.getLocation();
		if(p.hasPotionEffect(PotionEffectType.POISON)) return;
		if(p.hasPotionEffect(PotionEffectType.WITHER)) return;
		if(p.getLocation().getBlock().getLocation().add(0, 2, 0).getBlock().getType() == null)return;
		if(!p.getLocation().getBlock().getLocation().add(0, 2, 0).getBlock().getType().equals(Material.AIR))return;
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			@Override
			public void run() {
				if(p == null || !p.isValid() ) return;
				if(!p.isOnline()) return;
				if(p.getLocation().distanceSquared(hitloc) <= 0.01D){
					if(PlayerData.antiKb.containsKey(p)){
						if(PlayerData.antiKb.get(p) >= 3){
							System.out.println("" + PlayerData.antiKb.get(p));
							PlayerData.antiKb.remove(p);
							Ban.BanPlayer("AntiKnockBack", p, "WARN", plugin);
						}else{
							Integer dou = PlayerData.antiKb.get(p);
							PlayerData.antiKb.remove(p);
							dou = dou + 1;
							PlayerData.antiKb.put(p, dou);
						}
					}else{
						PlayerData.antiKb.put(p, 1);
					}
				}
			}}, 10);
	}
	
}
