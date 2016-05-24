package fr.thet.warn.listener;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import fr.thet.warn.Main;

public class PlayerLogin implements Listener{

	private Main plugin;
	
	public PlayerLogin(Main plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent e){
		Player p = e.getPlayer();
		FileConfiguration config = plugin.getConfig();
		if(config.contains("ban." + p.getName()) && p.isOp() == false){
			e.setResult(Result.KICK_OTHER);
			e.setKickMessage("§c§lBanni pour §4" + config.getString("ban." + p.getName()));
		}
		if(config.contains("ban." + p.getName()) && p.isOp() == true){
			config.set("ban." + p.getName(), null);
		}
	}
	
}
