package fr.thet.warn.listener;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

import fr.thet.warn.Main;
import fr.thet.warn.data.PlayerData;
import fr.thet.warn.sanction.Ban;
import fr.thet.warn.sanction.Warning;

public class EntityShootBow implements Listener {

	private Main plugin;
	
	public EntityShootBow(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onShootBow(EntityShootBowEvent e){
		FileConfiguration config = plugin.getConfig();
		if(e.getEntity() instanceof Player){
			Player p = (Player) e.getEntity();
			if(PlayerData.lastarr.containsKey(p) && !config.contains("ban."+ p.getName())){
				long lastshoot = PlayerData.lastarr.get(p);
				lastshoot =  System.currentTimeMillis() - lastshoot;
				if(lastshoot < 100){
					if(PlayerData.bow.containsKey(p)){
						int i = PlayerData.bow.get(p);
						i++;
						PlayerData.bow.remove(p);
						if(i > 4){
							Warning.WarningOther(p, "FastBow");
						}
						if(i >= 6){
							Ban.BanPlayer("FastBow", p, "WARN", plugin);
							return;
						}
						PlayerData.bow.put(p, i);
					}else{
						PlayerData.bow.put(p, 1);
					}
				}
				PlayerData.lastarr.remove(p);
				PlayerData.lastarr.put(p, System.currentTimeMillis());
			}else{
				PlayerData.lastarr.put(p, System.currentTimeMillis());
			}
		}
	}
	
}
