package fr.thet.warn.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;

import fr.thet.warn.data.PlayerData;

public class BlockIgnite implements Listener {

	@EventHandler
	public void onBlockIgnite(BlockIgniteEvent e){
		long mili = System.currentTimeMillis();
		if((mili - PlayerData.lastban) < 1500){
			e.setCancelled(true);
		}
	}
	
}
