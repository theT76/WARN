package fr.thet.warn.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.thet.warn.data.PlayerData;

public class PlayerQuit implements Listener {

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e){
		e.setQuitMessage(null);
		Player p = e.getPlayer();
		if(PlayerData.antiKb.containsKey(p)){
			PlayerData.antiKb.remove(p);
		}
	}
	
}
