package fr.thet.warn.listener;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;

import fr.thet.warn.Main;
import fr.thet.warn.data.PlayerData;
import fr.thet.warn.sanction.Ban;
import fr.thet.warn.sanction.Warning;

public class EntityRegainHealth implements Listener {

	private Main plugin;
	
	public EntityRegainHealth(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onHealthRegen(EntityRegainHealthEvent e){
		FileConfiguration config = plugin.getConfig();
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			if(e.getRegainReason().equals(RegainReason.SATIATED)){
				if(PlayerData.lastreg.containsKey(p) && !config.contains("ban."+ p.getName())){
					long lastregen = PlayerData.lastreg.get(p);
					lastregen =  System.currentTimeMillis() - lastregen;
					if(lastregen < 2000){
						if(PlayerData.rgn.containsKey(p)){
							int i = PlayerData.rgn.get(p);
							i++;
							PlayerData.rgn.remove(p);
							if(i > 2){
								Warning.WarningOther(p, "AutoRegen");
							}
							if(i >= 4){
								Ban.BanPlayer("AutoRegen", p, "WARN", plugin);
								return;
							}
							PlayerData.rgn.put(p, i);
						}else{
							PlayerData.rgn.put(p, 1);
						}
					}
					PlayerData.lastreg.remove(p);
					PlayerData.lastreg.put(p, System.currentTimeMillis());
				}else{
					PlayerData.lastreg.put(p, System.currentTimeMillis());
				}
			}
		}
	}
	
}
